package org.ucas.cyg.dao;

import org.apache.ibatis.annotations.*;
import org.ucas.cyg.domain.MiaoShaOrder;
import org.ucas.cyg.domain.OrderInfo;

/**
 * @Author: yunguan cheng
 * @Date: 2018/6/3 22:51
 * @Description:
 */

@Mapper
public interface OrderDao {


    @Select("select * from miaosha_order mo where mo.user_id = #{userId} and mo.goods_id = #{goodsId}")
    public MiaoShaOrder getMiaoShaOrderByUserIdGoodsId(@Param("userId") long userId,@Param("goodsId") long goodsId);

    @Insert("insert into order_info(user_id, goods_id, delivery_addr_id, goods_name,goods_count, goods_price, order_channel, status, create_date, pay_date) values(#{userId}, #{goodsId}, #{deliveryAddrId}, #{goodsName}, #{goodsCount}, #{goodsPrice}, #{orderChannel}, #{status}, #{createDate}, #{payDate})")
    @SelectKey(keyColumn = "id", keyProperty = "id", resultType = long.class, before = false, statement = "select last_insert_id()")
    public long insert(OrderInfo orderInfo);

    @Insert("insert into miaosha_order(user_id, order_id, goods_id) values(#{userId}, #{orderId}, #{goodsId})")
    public int inserMiaoShaOrder(MiaoShaOrder miaoShaOrder);
}
