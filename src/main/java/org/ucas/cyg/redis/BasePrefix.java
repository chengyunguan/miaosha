package org.ucas.cyg.redis;

/**
 * @Author: yunguan cheng
 * @Date: 2018/5/30 21:12
 * @Description:
 */
public class BasePrefix implements KeyPrefix {

    public int expireSeconds;

    public String prefix;

    public BasePrefix(String prefix) { // 0代表永远不过期
        this(0, prefix);
    }

    public BasePrefix(int expireSeconds, String prefix) {
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }

    @Override
    public int expireSeconds() {
        return expireSeconds;
    }

    @Override
    public String getPrefix() {
        String className = getClass().getSimpleName();
        return className + "-" + prefix + ":";
    }

}
