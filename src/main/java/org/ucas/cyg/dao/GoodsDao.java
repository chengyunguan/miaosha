package org.ucas.cyg.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.ucas.cyg.domain.Goods;
import org.ucas.cyg.domain.MiaoShaGoods;
import org.ucas.cyg.vo.GoodsVo;

import java.util.List;

/**
 * @Author: yunguan cheng
 * @Date: 2018/6/3 16:05
 * @Description:
 */
@Mapper
public interface GoodsDao {

    @Select("select g.*, mg.miaosha_price, mg.stock_count, mg.start_date, mg.end_date from miaosha_goods mg left join goods g on mg.id = g.id")
    public List<GoodsVo> listGoodsVo();

    @Select("select g.*, mg.miaosha_price, mg.stock_count, mg.start_date, mg.end_date from miaosha_goods mg left join goods g on mg.id = g.id where g.id = #{goodsId}")
    public GoodsVo getGoodsVoByGoodsId(@Param("goodsId") long goodsId);

    @Update("update miaosha_goods set stock_count = stock_count - 1 where goods_id = #{goodsId}")
    public void reduceStock(MiaoShaGoods g);
}
