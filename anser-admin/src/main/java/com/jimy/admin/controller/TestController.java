package com.jimy.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 *
 * @author zhoujinming
 * @Description com.jimy.admin.controller
 * @date 2020-03-28 16:04
 **/
@Slf4j
@RestController
public class TestController {

    @GetMapping("/test")
    public void test() {
        log.info("testing .......................................................");
    }
}
