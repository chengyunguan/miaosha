package org.ucas.cyg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ucas.cyg.domain.MiaoShaUser;
import org.ucas.cyg.result.Result;

/**
 * @Author: yunguan cheng
 * @Date: 2018/6/7 16:36
 * @Description:
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/info")
    @ResponseBody
    public Result<MiaoShaUser> info(MiaoShaUser user, Model model) {
        return Result.success(user);
    }
}
