package org.ucas.cyg.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author: yunguan cheng
 * @Date: 2018/5/29 16:03
 * @Description:    把配置文件的信息，读取并自动封装成实体类
 */

@Component
@ConfigurationProperties(prefix = "redis")
public class RedisConfig {

    @Value("${redis.host}")
    private String host;

    @Value("${redis.port}")
    private int port;

    @Value("${redis.password}")
    private String password;

    @Value("${redis.timeout}")
    private int timeout;

    @Value("${redis.poolMaxTotal}")
    private int poolMaxTotal;

    @Value("${redis.poolMaxIdle}")
    private int poolMaxIdle;

    @Value("${redis.poolMaxWait}")
    private int poolMaxWait;

    public String getHost() {
        return host;
    }


    public int getPort() {
        return port;
    }


    public String getPassword() {
        return password;
    }


    public int getTimeout() {
        return timeout;
    }

    public int getPoolMaxTotal() {
        return poolMaxTotal;
    }


    public int getPoolMaxIdle() {
        return poolMaxIdle;
    }


    public int getPoolMaxWait() {
        return poolMaxWait;
    }

    @Override
    public String toString() {
        return "RedisConfig{" +
                "host='" + host + '\'' +
                ", port=" + port +
                ", password='" + password + '\'' +
                ", timeout=" + timeout +
                ", poolMaxTotal=" + poolMaxTotal +
                ", poolMaxIdle=" + poolMaxIdle +
                ", poolMaxWait=" + poolMaxWait +
                '}';
    }
}
