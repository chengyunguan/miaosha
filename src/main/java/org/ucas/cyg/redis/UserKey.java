package org.ucas.cyg.redis;

import org.ucas.cyg.domain.User;

/**
 * @Author: yunguan cheng
 * @Date: 2018/5/30 21:17
 * @Description:
 */
public class UserKey extends BasePrefix {


    public UserKey(String prefix) {
        super(prefix);
    }

    public static UserKey getById = new UserKey("id");
    public static UserKey getByName = new UserKey("name");
}
