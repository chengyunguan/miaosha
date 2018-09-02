package org.ucas.cyg.redis;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.ucas.cyg.ApplicationTests;

import static org.junit.Assert.*;

/**
 * @Author: yunguan cheng
 * @Date: 2018/5/30 17:22
 * @Description:
 */
public class RedisConfigTest extends ApplicationTests {

    @Autowired
    private RedisConfig redisConfig;

    @Ignore
    @Test
    public void getTest() {
        System.out.println(redisConfig.toString());
    }

}