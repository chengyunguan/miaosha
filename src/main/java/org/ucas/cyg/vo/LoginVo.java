package org.ucas.cyg.vo;

import org.hibernate.validator.constraints.Length;
import org.ucas.cyg.validator.isMobile;

import javax.validation.constraints.NotNull;

/**
 * @Author: yunguan cheng
 * @Date: 2018/6/2 15:26
 * @Description: 登录参数
 */
public class LoginVo {

    @NotNull
    @isMobile
    private String mobile;

    @NotNull
    @Length(min = 32)
    private String password;

    @Override
    public String toString() {
        return "LoginVo{" +
                "mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
