package com.jimy.common.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jimy.common.resource.config.ResourcePermissionConfig;
import com.jimy.common.resource.exception.CustomAccessDeniedHandler;
import com.jimy.common.resource.exception.ResourceAuthExceptionEntryPoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description //TODO $如果是web服务就自动配置
 * @Date 22:38
 * @Author yzcheng90@qq.com
 **/
@Configuration
@ConditionalOnWebApplication
public class ApplicationConfig {

    @Bean
    public ResourcePermissionConfig resourcePermissionConfig(){
        return new ResourcePermissionConfig();
    }

    @Bean
    public CustomAccessDeniedHandler customAccessDeniedHandler(){
        return new CustomAccessDeniedHandler();
    }

    @Bean
    public ResourceAuthExceptionEntryPoint resourceAuthExceptionEntryPoint(){
        return new ResourceAuthExceptionEntryPoint(objectMapper());
    }

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }

}
