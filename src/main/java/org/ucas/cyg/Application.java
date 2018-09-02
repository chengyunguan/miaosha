package org.ucas.cyg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ucas.cyg.redis.RedisConfig;

@SpringBootApplication
public class Application {


    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
