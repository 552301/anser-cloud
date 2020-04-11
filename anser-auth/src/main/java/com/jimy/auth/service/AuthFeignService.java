package com.jimy.auth.service;

import com.jimy.auth.service.fallback.AuthFeignServiceFallbackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 功能描述
 *
 * @author zhoujinming
 * @Description com.jimy.auth.service
 * @date 2020-03-28 16:18
 **/
@FeignClient(value = "anser-admin", fallback = AuthFeignServiceFallbackImpl.class)
public interface AuthFeignService {

    /**
     * 这里暴露一个Feign接口地址，其中`@GetMapping`中的地址一定对应了`anser-admin`服务中某个Controller中的请求地址（如果`anser-admin`服务中没有这个接口地址就会404）
     * 如果其他地方调用了AuthFeignService接口的hello方法，FeignClient将类似通过转发的方式去请求调用`anser-admin`服务中符合的接口地址的方法
     * 如果请求传递了参数，需要加@RequestParam注解标识。如果URL中有动态参数，要添加@PathVariable注解
     * 记得一定要在@FeignClient里面加上fallback = AuthFeignServiceFallbackImpl.class，在此处浪费很多时间
     *
     * @param name
     * @return
     */
    @GetMapping("/admin/hello/{name}")
    public String hello(@PathVariable(name = "name") String name);
}