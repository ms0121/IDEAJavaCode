package com.liu.rabbit_ttl.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author lms
 * @date 2021-09-16 - 11:33
 */

@Slf4j
@Controller
@RequestMapping("ttl")
public class SendMsgController {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @GetMapping("sendMsg/{message}")
    public void send(@PathVariable("message") String message) {
        log.info("当前时间：{}, 发送一条信息给两个 TTL  队列:{}", new Date(), message);
        // 生产者发送消息，指定交换机，路由key，发送的消息
        rabbitTemplate.convertAndSend("X", "XA", " 消息来自 ttl  为 10S  的队列: " + message);
        rabbitTemplate.convertAndSend("X", "XB", " 消息来自 ttl  为 40S  的队列: " + message);
    }

    /**
     * 设置指定过期时间的队列
     * @param message
     * @param ttlTime
     */
    @GetMapping("sendExpirationMsg/{message}/{ttlTime}")
    public void send(@PathVariable String message,
                     @PathVariable String ttlTime){
        log.info(" 当前时间：{}, 发送一条时长{} 毫秒 TTL  信息给队列 C:{}", new Date(),ttlTime, message);

        rabbitTemplate.convertAndSend("X", "XC", message, msg -> {
            // 根据路径传过来的过期时间从而设置队列的过期时间
            msg.getMessageProperties().setExpiration(ttlTime);
            return msg;
        });
    }
}
