package com.jimy.common.rabbitmq.config;

import com.jimy.common.rabbitmq.constants.RabbitMQConstants;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author czx
 * @title: RabbitMQConfig
 * @projectName ms
 * @description: TODO
 * @date 2019/8/711:32
 */
@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue permissionQueue(){
        return new Queue(RabbitMQConstants.PERMISSION_QUEUE);
    }

    @Bean
    public Queue loginLogQueue(){
        return new Queue(RabbitMQConstants.LOGIN_LOG_QUEUE);
    }
}
