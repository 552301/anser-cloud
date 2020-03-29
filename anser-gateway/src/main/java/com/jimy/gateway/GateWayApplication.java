package com.jimy.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;

/**
 * @Author: jimy
 * @Date: 2020/3/28 23:54
 * @Description:
 */
@EnableDiscoveryClient
@SpringBootApplication
public class GateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class, args);
    }
}
