package com.jimy.common.resource.config;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.jimy.common.core.component.URLConvertUtil;
import com.jimy.common.core.entity.PermissionEntityVO;
import com.jimy.common.rabbitmq.producer.PermissionProducer;
import com.jimy.common.resource.annotation.ResourcePermission;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author czx
 * @title: ResourcePermissionConfig
 * @projectName ms
 * @description: TODO 权限加载
 * @date 2019/8/29:28
 */
@Slf4j
public class ResourcePermissionConfig implements InitializingBean {

    @Autowired
    private WebApplicationContext applicationContext;

    @Value("${spring.application.name}")
    private String applicationName;

    @Autowired
    private PermissionProducer permissionProducer;

    @Getter
    @Setter
    private List<PermissionEntityVO> permissionEntities = new ArrayList<>();

    @Override
    public void afterPropertiesSet(){
        log.info("===============ResourcePermissionConfig==============");
        RequestMappingHandlerMapping mapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
        Map<RequestMappingInfo, HandlerMethod> map = mapping.getHandlerMethods();
        map.keySet().forEach(mappingInfo -> {
            HandlerMethod handlerMethod = map.get(mappingInfo);
            ResourcePermission method = AnnotationUtils.findAnnotation(handlerMethod.getMethod(), ResourcePermission.class);
            Optional.ofNullable(method)
                    .ifPresent(resourcePermission -> mappingInfo
                            .getPatternsCondition()
                            .getPatterns()
                            .forEach(url -> {
                                String strUrl = URLConvertUtil.capture(url);
                                String permission = URLConvertUtil.convert(url);
                                permissionEntities.add(PermissionEntityVO
                                        .builder()
                                        .name(method.value())
                                        .permission(permission)
                                        .serviceId(applicationName)
                                        .url(strUrl)
                                        .build());
                            }));
            ResourcePermission controller = AnnotationUtils.findAnnotation(handlerMethod.getBeanType(), ResourcePermission.class);
            Optional.ofNullable(controller)
                    .ifPresent(resourcePermission -> mappingInfo
                            .getPatternsCondition()
                            .getPatterns()
                            .forEach(url -> {
                                String strUrl = URLConvertUtil.capture(url);
                                String permission = URLConvertUtil.convert(url);
                                if(StrUtil.isNotBlank(permission)){
                                    permissionEntities.add(PermissionEntityVO
                                            .builder()
                                            .name(method.value())
                                            .permission(permission)
                                            .serviceId(applicationName)
                                            .url(strUrl)
                                            .build());
                                }
                            }));
        });
        if(CollUtil.isNotEmpty(permissionEntities)){
            permissionProducer.send(permissionEntities);
        }
    }
}
