package com.jimy.common.rabbitmq.producer;

import com.jimy.common.core.entity.PermissionEntityVO;
import com.jimy.common.rabbitmq.constants.RabbitMQConstants;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author czx
 * @title: PermissionProducer
 * @projectName ms
 * @description: TODO
 * @date 2019/8/711:35
 */
@Component
public class PermissionProducer {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(List<PermissionEntityVO> list){
        rabbitTemplate.convertAndSend(RabbitMQConstants.PERMISSION_QUEUE, list);
    }
}
