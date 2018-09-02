package org.ucas.cyg.redis;

/**
 * All rights Reserved, Designed By www.ie.ac.cn
 *
 * @version V1.0;
 * =================Modify Record=================
 * @Title: null.java
 * @Package org.ucas.cyg.redis
 * @Description: 简要描述方法的作用
 * @author: chengyunguan
 * @date: 2018/9/2 21:27
 * @Modifier @date			 @Content
 * chengyunguan     2018/9/2 21:27	新建
 * @Copyright: 2018 www.ie.ac.cn Inc. All rights reserved.
 */
public class GoodsKey extends BasePrefix {

    private GoodsKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static GoodsKey getGoodsList = new GoodsKey(60,"gk");
    public static GoodsKey getGoodsDetail = new GoodsKey(60, "gd");

}
