package org.ucas.cyg.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.ucas.cyg.domain.MiaoShaUser;
import org.ucas.cyg.icontext.SpringWebContextUtil;
import org.ucas.cyg.redis.GoodsKey;
import org.ucas.cyg.redis.RedisService;
import org.ucas.cyg.service.GoodsService;
import org.ucas.cyg.service.MiaoShaUserService;
import org.ucas.cyg.service.UserService;
import org.ucas.cyg.vo.GoodsVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author: yunguan cheng
 * @Date: 2018/6/3 11:06
 * @Description:
 */

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private MiaoShaUserService miaoShaUserService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private ThymeleafViewResolver thymeleafViewResolver;

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping(value = "/to_list", produces = "text/html")
    @ResponseBody
    public String list(HttpServletRequest request, HttpServletResponse response, Model model, MiaoShaUser user) {
        model.addAttribute("user", user);
        List<GoodsVo> goodsList = goodsService.listGoodsVo();
        model.addAttribute("goodsList", goodsList);
        /**
         * 取缓存
         */
        String html = redisService.get(GoodsKey.getGoodsList, "", String.class);
        if (StringUtils.isNoneEmpty(html)) {
            return html;
        }
        /**
         * 手动渲染
         */
        SpringWebContextUtil ctx = new SpringWebContextUtil(request, response, request.getServletContext(),
                request.getLocale(), model.asMap(), applicationContext);
        html = thymeleafViewResolver.getTemplateEngine().process("goods_list", ctx);
        if (StringUtils.isNotEmpty(html)) {
            redisService.set(GoodsKey.getGoodsDetail, "", html);
        }
        return html;
    }



    @RequestMapping("/to_detail/{goodsId}")
    @ResponseBody
    public String detail(HttpServletRequest request, HttpServletResponse response, Model model, MiaoShaUser user, @PathVariable("goodsId") long goodsId) {
        model.addAttribute("user", user);
        GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
        model.addAttribute("goods", goods);
        long startTime = goods.getStartDate().getTime();
        long endTime = goods.getEndDate().getTime();
        long now = System.currentTimeMillis();
        int miaoshaStatus = 0;
        int remainSeconds = 0;
        if (now < startTime) {
            //  秒杀还没开始
            miaoshaStatus = 0;
            remainSeconds = (int) (startTime - now) / 1000;
        } else if (now > endTime) {
            //  秒杀已经结束
            miaoshaStatus = 2;
            remainSeconds = -1;
        } else {
            //  秒杀正在进行
            miaoshaStatus = 1;
            remainSeconds = 0;
        }
        model.addAttribute("miaoshaStatus", miaoshaStatus);
        model.addAttribute("remainSeconds", remainSeconds);

        /**
         * 取缓存
         */
        String html = redisService.get(GoodsKey.getGoodsDetail, goodsId + "", String.class);
        if (StringUtils.isNotEmpty(html)) {
            return html;
        }
        /**
         * 手动渲染
         */
        SpringWebContextUtil ctx = new SpringWebContextUtil(request, response, request.getServletContext(),
                request.getLocale(), model.asMap(), applicationContext);
        html = thymeleafViewResolver.getTemplateEngine().process("goods_detail", ctx);
        if (StringUtils.isNotEmpty(html)) {
            redisService.set(GoodsKey.getGoodsDetail, goodsId + "", html);
        }
        return html;
    }
}
