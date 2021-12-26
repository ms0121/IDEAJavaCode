package com.liu.rabbit_ttl.consumer;

import com.liu.rabbit_ttl.config.ConfirmConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lms
 * @date 2021-09-17 - 15:52
 */

@Slf4j
@Component
public class ConfirmConsumer {

    @RabbitListener(queues = ConfirmConfig.CONFIRM_QUEUE)
    public void getMeg(Message message){
        log.info("接收到的消息是: {}", new String(message.getBody()));
    }
}
