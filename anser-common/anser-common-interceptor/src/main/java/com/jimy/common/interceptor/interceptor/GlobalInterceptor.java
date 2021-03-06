package com.jimy.common.interceptor.interceptor;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.jimy.common.cache.component.RedisUUID;
import com.jimy.common.core.constants.SecurityConstants;
import com.jimy.common.core.entity.R;
import com.jimy.common.resource.config.AuthIgnoreConfig;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @Description //TODO $全局过滤
 * @Date 21:35
 * @Author yzcheng90@qq.com
 **/
@Slf4j
public class GlobalInterceptor implements HandlerInterceptor {

    @Getter
    @Setter
    private RedisUUID redisUUID;

    @Getter
    @Setter
    private AuthIgnoreConfig authIgnoreConfig;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
        //获取忽略URL数量
        long exist =  authIgnoreConfig.getIgnoreUrls().stream().filter(url-> url.trim().equals(request.getRequestURI())).count();
        //判断忽略URL数量是否不等于0
        if(exist != 0){
            return true;
        }
        String secretKey = request.getHeader(SecurityConstants.SECRET_KEY);
        if(StrUtil.isNotBlank(secretKey)){
            String key = (String) redisUUID.get(SecurityConstants.SECRET_KEY);
            if(!StrUtil.isBlank(key) && secretKey.equals(key)){
                return true;
            }
        }
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(JSONUtil.toJsonStr(R.error("illegal request")));
        return false;
    }
}
