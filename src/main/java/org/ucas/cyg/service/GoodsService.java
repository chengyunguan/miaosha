package org.ucas.cyg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ucas.cyg.dao.GoodsDao;
import org.ucas.cyg.domain.Goods;
import org.ucas.cyg.domain.MiaoShaGoods;
import org.ucas.cyg.vo.GoodsVo;

import java.util.List;

/**
 * @Author: yunguan cheng
 * @Date: 2018/6/3 16:05
 * @Description:
 */
@Service
public class GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    public List<GoodsVo> listGoodsVo() {
        return goodsDao.listGoodsVo();
    }

    public GoodsVo getGoodsVoByGoodsId(long goodsId) {
        return goodsDao.getGoodsVoByGoodsId(goodsId);
    }

    public void reduceStock(GoodsVo goods) {
        MiaoShaGoods g = new MiaoShaGoods();
        g.setGoodsId(goods.getId());
        goodsDao.reduceStock(g);
    }
}
