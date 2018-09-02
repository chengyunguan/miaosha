package org.ucas.cyg.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: yunguan cheng
 * @Date: 2018/6/2 16:04
 * @Description:
 */
public class ValidateUtil {
    private static final String REGEX_MOBILE = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
    private static final Pattern mobile_pattern = Pattern.compile(REGEX_MOBILE);
    public static boolean isMobile(String mobile) {
        if (StringUtils.isEmpty(mobile)) {
            return false;
        }
        Matcher matcher = mobile_pattern.matcher(mobile);
        return matcher.matches();
    }
}
