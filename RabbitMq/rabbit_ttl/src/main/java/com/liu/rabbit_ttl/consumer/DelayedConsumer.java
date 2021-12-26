package com.liu.rabbit_ttl.consumer;


import com.liu.rabbit_ttl.config.DelayedConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author lms
 * @date 2021-09-24 - 8:17
 */
@Slf4j
@Component
public class DelayedConsumer {

    @RabbitListener(queues = DelayedConfig.DELAYED_QUEUE_NAME)
    public void receiveMsg(Message message){
        String msg = new String(message.getBody());
        log.info(" 当前时间：{}, 收到延时队列的消息：{}", new Date().toString(), msg);
    }
}
