package com.liu.rabbit_ttl.call;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author lms
 * @date 2021-09-17 - 17:02
 */

@Slf4j
@Component
public class MyCallback implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {

    @Resource
    private RabbitTemplate rabbitTemplate;

    // 必须在其他注解完成之后，才进行注入到rabbitTemplate中的confirmCallback属性当中，
    // 否则将会出现严重的错误
    @PostConstruct
    public void init(){
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnCallback(this);
    }

    /**
     * 发布确认的回调接口的实现:
     *      生产者给交换机进行发送消息的时候，无论是否发送成功，都会执行当前的这个回调函数
     *
     *  消息发送成功：
     *      correlationData： 保存了回调消息的ID以及相关信息
     *      ack: true（表示是否收到消息）
     *      cause：原因
     *
     *  消息发送失败：
     *      correlationData： 保存了回调消息的ID以及相关信息
     *      ack： false
     *      cause：失败的原因
     * @param correlationData
     * @param ack
     * @param s
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String s) {
        String id = "";
        if (correlationData != null){
            id = correlationData.getId();
        }
        if (ack){
            log.info("信息id = {}, 交换机已经收到了生产者发送的消息", id);
        }else {
            log.info("信息id = {}, 交换机没有收到了生产者的消息, 失败的原因是：{}", id, s);
        }
    }

    /**
     * 当消息无法从交换机发送到指定的队列的时候，会给生产者一个回调信息
     * 只有消息不可达到的时候才会调用这个方法
     */
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        log.info("回退的消息是: {}, 回退的原因: {}, 执行回退操作的交换机是: {},其路由key是: {}",
                new String(message.getBody()), replyText, exchange, routingKey);
    }

}
