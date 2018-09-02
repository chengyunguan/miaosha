package org.ucas.cyg.util;

import java.util.UUID;

/**
 * @Author: yunguan cheng
 * @Date: 2018/6/3 10:07
 * @Description:
 */
public class UUIDUtil {

    public static String uuid() {
        //  生成的uuid默认是带"-"的，用replace去掉"-"
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
