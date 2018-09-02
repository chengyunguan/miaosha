package org.ucas.cyg.service;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.ucas.cyg.ApplicationTests;

import static org.junit.Assert.*;

/**
 * @Author: yunguan cheng
 * @Date: 2018/6/3 22:55
 * @Description:
 */
public class OrderServiceTest extends ApplicationTests {

    @Autowired
    private OrderService orderService;
    @Test
    @Ignore
    public void getMiaoShaOrderByUserIdGoodsId() {
        orderService.getMiaoShaOrderByUserIdGoodsId(1, 1);
    }
}