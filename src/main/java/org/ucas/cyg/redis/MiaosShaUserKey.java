package org.ucas.cyg.redis;

/**
 * @Author: yunguan cheng
 * @Date: 2018/5/30 21:17
 * @Description:
 */
public class MiaosShaUserKey extends BasePrefix {

    public static final int TOKEN_EXPIRE = 3600* 24 * 2;

    public MiaosShaUserKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static MiaosShaUserKey getByToken = new MiaosShaUserKey(TOKEN_EXPIRE, "tk");

    public static void main(String[] args) {
        System.out.println(MiaosShaUserKey.getByToken.getPrefix());
    }
}
