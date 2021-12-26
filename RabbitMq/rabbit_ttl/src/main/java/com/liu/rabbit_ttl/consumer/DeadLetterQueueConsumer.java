package com.liu.rabbit_ttl.consumer;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

/**
 * @author lms
 * @date 2021-09-16 - 11:38
 */
@Slf4j
@Component
public class DeadLetterQueueConsumer {

    // 监听指定的队列，
    @RabbitListener(queues = "QD")
    public void receiveD(Message message, Channel channel) throws IOException {
        String msg = new String(message.getBody());
        log.info(" 当前时间：{}, 收到死信队列信息{}", new Date().toString(), msg);
    }
}
