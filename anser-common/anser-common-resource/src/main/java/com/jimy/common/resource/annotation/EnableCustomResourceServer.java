
package com.jimy.common.resource.annotation;
import com.jimy.common.resource.security.CustomResourceBeanDefinitionRegistrar;
import com.jimy.common.resource.security.RestTemplateConfig;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.lang.annotation.*;

/**
 * 定制的资源服务注解
 */
@Documented
@Inherited
@EnableResourceServer
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Import({RestTemplateConfig.class, CustomResourceBeanDefinitionRegistrar.class})
public @interface EnableCustomResourceServer {

}
