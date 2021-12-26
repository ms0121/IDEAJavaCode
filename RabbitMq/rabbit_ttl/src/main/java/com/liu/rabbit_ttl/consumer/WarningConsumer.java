package com.liu.rabbit_ttl.consumer;

import com.liu.rabbit_ttl.config.ConfirmConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lms
 * @date 2021-09-17 - 21:16
 */

@Slf4j
@Component
public class WarningConsumer {

    // 监听备份报警队列中的消息
    @RabbitListener(queues = ConfirmConfig.WARNING_QUEUE)
    public void getMeg(Message message){
        String msg = new String(message.getBody());
        log.info("收到来自报警队列的消息: {}", msg);
    }
}
