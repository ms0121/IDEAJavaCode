package com.liu.rabbit_ttl.controller;


import com.liu.rabbit_ttl.config.DelayedConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author lms
 * @date 2021-09-24 - 8:20
 */
@Controller
@Slf4j
@RequestMapping("ttl")
public class DelayedProducer {

    @Resource
    private RabbitTemplate rabbitTemplate;

    // 基于插件的延迟队列的实现
    @RequestMapping("sendDelayMsg2/{message}/{delayTime}")
    public void sendMsg(@PathVariable String message, @PathVariable Integer delayTime){
        rabbitTemplate.convertAndSend(DelayedConfig.DELAYED_EXCHANGE_NAME, DelayedConfig.DELAYED_ROUTING_KEY,
                message, correlationData ->{
            correlationData.getMessageProperties().setDelay(delayTime);
            return correlationData;
        });
        log.info("  当 前 时 间 ： {},  发 送 一 条 延 迟 {}  毫 秒 的 信 息 给 队 列 delayed.queue:{}", new Date(), delayTime, message);
    }

}
