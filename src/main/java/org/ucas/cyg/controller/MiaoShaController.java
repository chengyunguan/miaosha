package org.ucas.cyg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.ucas.cyg.domain.MiaoShaOrder;
import org.ucas.cyg.domain.MiaoShaUser;
import org.ucas.cyg.domain.OrderInfo;
import org.ucas.cyg.result.CodeMsg;
import org.ucas.cyg.service.GoodsService;
import org.ucas.cyg.service.MiaoShaService;
import org.ucas.cyg.service.OrderService;
import org.ucas.cyg.vo.GoodsVo;

/**
 * @Author: yunguan cheng
 * @Date: 2018/6/3 22:33
 * @Description:
 */

@Controller
@RequestMapping("/miaosha")
public class MiaoShaController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private MiaoShaService miaoShaService;

    @RequestMapping("/do_miaosha")
    public String miaosha(Model model, MiaoShaUser user, @RequestParam long goodsId) {
        model.addAttribute("user", user);
        if (user == null) {
            return "login";
        }
        //  判断库存
        GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
        int stock = goods.getStockCount();
        if (stock <= 0) {
            model.addAttribute("errmsg", CodeMsg.MIAO_SHA_OVER.getMsg());
            return "miaosha_fail";
        }
        //  判断重复秒杀
        MiaoShaOrder order = orderService.getMiaoShaOrderByUserIdGoodsId(user.getId(), goodsId);
        if (order != null) {
            model.addAttribute("errmsg", CodeMsg.REPEATE_MIAOSHA.getMsg());
            return "miaosha_fail";
        }
        //  1.减库存、2.下订单、3.写入秒杀订单
        OrderInfo orderInfo = miaoShaService.miaosha(user, goods);
        model.addAttribute("orderInfo", orderInfo);
        model.addAttribute("goods", goods);
        return "order_detail";

    }
}
