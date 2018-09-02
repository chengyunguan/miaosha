package org.ucas.cyg.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ucas.cyg.domain.MiaoShaUser;
import org.ucas.cyg.result.CodeMsg;
import org.ucas.cyg.result.Result;
import org.ucas.cyg.service.MiaoShaUserService;
import org.ucas.cyg.util.ValidateUtil;
import org.ucas.cyg.vo.LoginVo;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @Author: yunguan cheng
 * @Date: 2018/6/2 14:25
 * @Description:
 */

@Controller
@RequestMapping("/login")
public class LogInController {

    private static Logger log = LoggerFactory.getLogger(LogInController.class);

    @Autowired
    private MiaoShaUserService miaoShaUserService;

    @RequestMapping("/to_login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/do_login")
    @ResponseBody
    public Result<Boolean> doLogin(HttpServletResponse response, @Valid LoginVo loginVo) {
        log.info(loginVo.toString());
        //  登录
        miaoShaUserService.login(response, loginVo);
        return Result.success(true);
    }
}
