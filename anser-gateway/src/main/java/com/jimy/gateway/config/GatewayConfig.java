package com.jimy.gateway.config;

import com.jimy.gateway.filter.TokenFilter;
import com.jimy.gateway.handler.RequestBodyRoutePredicateFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: jimy
 * @Date: 2020/3/29 22:53
 * @Description:
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RequestBodyRoutePredicateFactory requestBodyRoutePredicateFactory() {
        return new RequestBodyRoutePredicateFactory();
    }

    @Bean
    public TokenFilter tokenFilter(){
        return new TokenFilter();
    }
}