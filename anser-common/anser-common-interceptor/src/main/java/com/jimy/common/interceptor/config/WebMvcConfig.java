package com.jimy.common.interceptor.config;

import com.jimy.common.cache.component.RedisUUID;
import com.jimy.common.interceptor.interceptor.GlobalInterceptor;
import com.jimy.common.resource.config.AuthIgnoreConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description //TODO $
 * @Date 21:46
 * @Author yzcheng90@qq.com
 **/
@Configurable
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private RedisUUID redisUUID;

    @Autowired
    private WebApplicationContext applicationContext;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        GlobalInterceptor interceptor = new GlobalInterceptor();
        interceptor.setRedisUUID(redisUUID);
        interceptor.setAuthIgnoreConfig(applicationContext.getBean(AuthIgnoreConfig.class));
        registry.addInterceptor(interceptor).addPathPatterns("/**");
    }
}
