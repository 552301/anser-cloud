package com.jimy.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 功能描述
 *
 * @author zhoujinming
 * @Description com.jimy.auth
 * @date 2020-03-28 16:10
 **/
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }
}