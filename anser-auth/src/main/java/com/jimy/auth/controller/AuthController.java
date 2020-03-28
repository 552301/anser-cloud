package com.jimy.auth.controller;

import com.jimy.auth.service.AuthFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 *
 * @author zhoujinming
 * @Description com.jimy.auth.controller
 * @date 2020-03-28 16:17
 **/
@RestController
public class AuthController {

    @Autowired
    private AuthFeignService authFeignService;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "hello " + name + ", this is anser-auth";
    }

    @GetMapping("/feignHello/{name}")
    public String feignHello(@PathVariable String name) {
        return authFeignService.hello(name);
    }
}