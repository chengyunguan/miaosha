package org.ucas.cyg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ucas.cyg.dao.GoodsDao;
import org.ucas.cyg.domain.Goods;
import org.ucas.cyg.domain.MiaoShaUser;
import org.ucas.cyg.domain.OrderInfo;
import org.ucas.cyg.vo.GoodsVo;

/**
 * @Author: yunguan cheng
 * @Date: 2018/6/3 22:46
 * @Description:
 */
@Service
public class MiaoShaService {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private OrderService orderService;

    @Transactional
    public OrderInfo miaosha(MiaoShaUser user, GoodsVo goods) {
        //  1.减库存
        goodsService.reduceStock(goods);

        //  2.下订单,写入秒杀订单 order_info,miaosha_order
        return orderService.createOrder(user, goods);
    }
}
