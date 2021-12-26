package com.liu.rabbit_ttl.controller;

import com.liu.rabbit_ttl.config.ConfirmConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author lms
 * @date 2021-09-17 - 15:45
 */

@Slf4j
@Controller
@RequestMapping("confirm")
public class ConfirmProducer {

    @Resource
    private RabbitTemplate rabbitTemplate;

    // 发送消息
    @GetMapping("sendMessage/{message}")
    public void getMessage(@PathVariable String message){
        // 需要设置correlationData的信息
        CorrelationData correlationData = new CorrelationData("100");

        // 生产者给交换机发送消息，指定交换机和对应的路由key
        // 1.当生产者无法发送消息给交换机（设置错误的交换机），也会调用回调函数
        rabbitTemplate.convertAndSend(ConfirmConfig.CONFIRM_EXCHANGE, ConfirmConfig.CONFIRM_KEY,
                message, correlationData);
        log.info("发送的消息是: {}", message);

        correlationData.setId("200");
        rabbitTemplate.convertAndSend(ConfirmConfig.CONFIRM_EXCHANGE, ConfirmConfig.CONFIRM_KEY + "123",
                message, correlationData);
        log.info("第二次发送的消息是: {}", message);


    }


}
