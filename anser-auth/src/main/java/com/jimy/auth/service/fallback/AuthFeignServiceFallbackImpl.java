package com.jimy.auth.service.fallback;

import com.jimy.auth.service.AuthFeignService;
import org.springframework.stereotype.Component;

/**
 * @Author: jimy
 * @Date: 2020/3/28 22:56
 * @Description:
 */
@Component
public class AuthFeignServiceFallbackImpl implements AuthFeignService {

    @Override
    public String hello(String name) {
        return "hello " + name + ", this is anser-auth, but request error";
    }
}