package org.ucas.cyg.redis;

/**
 * @Author: yunguan cheng
 * @Date: 2018/5/30 21:10
 * @Description:
 */
public interface KeyPrefix {

    public int expireSeconds();

    public String getPrefix();
}
