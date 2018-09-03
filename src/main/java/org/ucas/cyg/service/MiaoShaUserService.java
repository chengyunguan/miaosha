package org.ucas.cyg.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ucas.cyg.dao.MiaoShaUserDao;
import org.ucas.cyg.domain.MiaoShaUser;
import org.ucas.cyg.exception.GlobleException;
import org.ucas.cyg.redis.MiaosShaUserKey;
import org.ucas.cyg.redis.RedisService;
import org.ucas.cyg.redis.UserKey;
import org.ucas.cyg.result.CodeMsg;
import org.ucas.cyg.util.MD5Util;
import org.ucas.cyg.util.UUIDUtil;
import org.ucas.cyg.vo.LoginVo;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: yunguan cheng
 * @Date: 2018/6/2 15:49
 * @Description:
 */

@Service
public class MiaoShaUserService {

    @Autowired
    private MiaoShaUserDao miaoShaUserDao;

    @Autowired
    private RedisService redisService;

    public static final String COOKIE_NAME_TOKEN = "token";

    public MiaoShaUser getById(long id) {
        return miaoShaUserDao.getById(id);
    }

    public boolean updatePassword(long id, String newPassword) {
        /**
         * 取user
         */
        MiaoShaUser user = getById(id);
        if (user == null) {
            throw new GlobleException(CodeMsg.MOBILE_NOT_EXIST);
        }
        /**
         * 更新数据库
         */
        MiaoShaUser tobeUpdate = new MiaoShaUser();
        tobeUpdate.setId(id);
        tobeUpdate.setPassword(newPassword);
        miaoShaUserDao.update(tobeUpdate);
        /**
         * 更新缓存
         */
        redisService.delete(UserKey.getById, "" + id);
        user.setPassword(tobeUpdate.getPassword());
        redisService.set(UserKey.getById, "" + id, user);
        return true;
    }

    public boolean login(HttpServletResponse response, LoginVo loginVo) {
        if (loginVo == null) {
            throw new GlobleException(CodeMsg.SERVER_ERROR);
        }
        String mobile = loginVo.getMobile();
        String formPass = loginVo.getPassword();

        //判断手机号是否存在
        MiaoShaUser user = miaoShaUserDao.getById(Long.parseLong(mobile));
        if (user == null) {
            throw new GlobleException(CodeMsg.MOBILE_NOT_EXIST);
        }

        //  验证密码
        String dbPass = user.getPassword();
        String salt = user.getSalt();
        String calcPass = MD5Util.formPassToDBPass(formPass, salt);
        if (!calcPass.equals(dbPass)) {
            throw new GlobleException(CodeMsg.PASSWORD_ERROR);
        }

        //  生成cookie
        String token = UUIDUtil.uuid();
        this.addCookie(response, token, user);
        return true;
    }

    private void addCookie(HttpServletResponse response, String token, MiaoShaUser user) {
        redisService.set(MiaosShaUserKey.getByToken, token, user);
        Cookie cookie = new Cookie(COOKIE_NAME_TOKEN, token);
        cookie.setMaxAge(MiaosShaUserKey.getByToken.expireSeconds);
        cookie.setPath("/");
        response.addCookie(cookie);

    }

    public MiaoShaUser getByToken(HttpServletResponse response, String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        MiaoShaUser user = redisService.get(MiaosShaUserKey.getByToken, token, MiaoShaUser.class);
        //  延长有效期
        if (user != null) {
            addCookie(response, token, user);
        }
        return user;
    }
}
