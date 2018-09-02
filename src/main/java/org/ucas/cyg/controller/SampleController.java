package org.ucas.cyg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ucas.cyg.domain.User;
import org.ucas.cyg.redis.KeyPrefix;
import org.ucas.cyg.redis.RedisConfig;
import org.ucas.cyg.redis.RedisService;
import org.ucas.cyg.redis.UserKey;
import org.ucas.cyg.result.CodeMsg;
import org.ucas.cyg.result.Result;
import org.ucas.cyg.service.UserService;

/**
 *  uo@Author: yunguan cheng
 * @Date: 2018/5/28 15:12
 * @Description:
 */

@Controller
@RequestMapping("/demo")
public class SampleController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService;
    @Autowired
    private RedisConfig redisConfig;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public Result<String> hello() {
        return Result.success("hello,imooc");
//        return Result.error(CodeMsg.SERVER_ERROR);
//        return new Result<String>(0, "success", "hello,imooc");
    }

    @RequestMapping("/helloError")
    @ResponseBody
    public Result<String> helloError() {
        return Result.error(CodeMsg.SERVER_ERROR);
//        return new Result<String>(0, "success", "hello,imooc");
    }

    @RequestMapping("/thymeleaf")
    @ResponseBody
    public String thymeleaf(Model model) {
        model.addAttribute("name", "cyg");
        return "hello";
//        return new Result<String>(0, "success", "hello,imooc");
    }

    @RequestMapping("/db/get")
    @ResponseBody
    public Result<User> getById() {
        User user = userService.getById(1);
        return Result.success(user);
    }

    @RequestMapping("/db/tx")
    @ResponseBody
    public Result<Boolean> tx() {
        Boolean is = userService.tx();
        return Result.success(is);
    }

    @RequestMapping("/redis/get")
    @ResponseBody
    public Result<User> redisGet() {
        String key = "1";
        User s=  redisService.get(UserKey.getById, key, User.class);
        System.out.println(s);
        return Result.success(s);
    }

    @RequestMapping("/redis/set")
    @ResponseBody
    public Result<User> redisSet() {
        User user = new User();
        user.setName("jackMa");
        user.setId(1);
        redisService.set(UserKey.getById, 1 + "", user);
        user = redisService.get(UserKey.getById, 1 + "", User.class);
        return Result.success(user);
    }
}
