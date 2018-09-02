package org.ucas.cyg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ucas.cyg.dao.OrderDao;
import org.ucas.cyg.domain.MiaoShaOrder;
import org.ucas.cyg.domain.MiaoShaUser;
import org.ucas.cyg.domain.OrderInfo;
import org.ucas.cyg.vo.GoodsVo;

import java.util.Date;

/**
 * @Author: yunguan cheng
 * @Date: 2018/6/3 22:41
 * @Description:
 */
@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;


    public MiaoShaOrder getMiaoShaOrderByUserIdGoodsId(long userId, long goodsId) {
        return orderDao.getMiaoShaOrderByUserIdGoodsId(userId, goodsId);
    }

    @Transactional
    public OrderInfo createOrder(MiaoShaUser user, GoodsVo goods) {
        //  写入order_info订单
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setCreateDate(new Date());
        orderInfo.setDeliveryAddrId(0L);
        orderInfo.setGoodsCount(1);
        orderInfo.setGoodsId(goods.getId());
        orderInfo.setGoodsName(goods.getGoodsName());
        orderInfo.setGoodsPrice(goods.getMiaoshaPrice());
        orderInfo.setOrderChannel(1);
        orderInfo.setStatus(0);
        orderInfo.setUserId(user.getId());
        long orderId = orderDao.insert(orderInfo);

        //写入秒杀订单
        MiaoShaOrder miaoShaOrder = new MiaoShaOrder();
        miaoShaOrder.setGoodsId(goods.getId());
        miaoShaOrder.setOrderId(orderId);
        miaoShaOrder.setUserId(user.getId());
        orderDao.inserMiaoShaOrder(miaoShaOrder);

        return orderInfo;
    }
}
