package org.ucas.cyg.redis;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.ucas.cyg.ApplicationTests;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import static org.junit.Assert.*;

/**
 * @Author: yunguan cheng
 * @Date: 2018/5/30 17:05
 * @Description:
 */
public class RedisPoolFactoryTest extends ApplicationTests {

    @Autowired
    private RedisPoolFactory redisPoolFactory;

    @Test
    @Ignore
    public void jedisPoolFactory() {
        JedisPool jedisPool = redisPoolFactory.jedisPoolFactory();
        Jedis jedis1 = jedisPool.getResource();
        System.out.println(jedis1.ping());
        Jedis jedis = new Jedis("192.168.172.13", 6379);
        jedis.auth("123456");
        System.out.println("连接状态：" + jedis.ping());
    }
}