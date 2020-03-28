package com.jimy.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 *
 * @author zhoujinming
 * @Description com.jimy.admin.controller
 * @date 2020-03-28 16:08
 **/
@RestController
public class AdminController {

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "hello " + name + ", this is admin-admin";
    }
}