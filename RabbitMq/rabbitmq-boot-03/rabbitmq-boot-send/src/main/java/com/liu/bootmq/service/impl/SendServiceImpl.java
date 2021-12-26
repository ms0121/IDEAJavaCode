package com.liu.bootmq.service.impl;

import com.liu.bootmq.service.SendService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lms
 * @date 2021-05-27 - 17:34
 */

@Service
public class SendServiceImpl implements SendService {

    // 注入amqp的模板类，利用这个对象来发送和接收信息
    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 参数1：交换机的名称
     * 参数2：RoutingKey
     * 参数3：发送的消息
     */
    @Override
    public void sendMessage(String message) {
        amqpTemplate.convertAndSend("bootDirectExchange", "bootDirectRoutingKey", message);
    }
}
