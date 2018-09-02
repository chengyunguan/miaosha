package org.ucas.cyg.service;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.ucas.cyg.ApplicationTests;
import org.ucas.cyg.domain.Goods;
import org.ucas.cyg.vo.GoodsVo;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: yunguan cheng
 * @Date: 2018/6/3 16:34
 * @Description:
 */
public class GoodsServiceTest extends ApplicationTests {

    @Autowired
    private GoodsService goodsService;

    @Test
    @Ignore
    public void listGoodsVo() {
        List<GoodsVo> goodsVos = goodsService.listGoodsVo();
        System.out.println("---------------------------------------------------------------------------------");
        for (GoodsVo goodsVo : goodsVos) {
            System.out.println(goodsVo);
        }
        System.out.println("---------------------------------------------------------------------------------");
    }

    @Test
    @Ignore
    public void getGoodsVoByGoodsId() {
        GoodsVo goodsVoByGoodsId = goodsService.getGoodsVoByGoodsId(1);
        System.out.println(goodsVoByGoodsId);
    }

    @Test
    @Ignore
    public void reduceStock() {
        GoodsVo g = new GoodsVo();
        g.setId(1L);
        goodsService.reduceStock(g);
    }
}