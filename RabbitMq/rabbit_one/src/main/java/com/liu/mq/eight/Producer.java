package com.liu.mq.eight;

import com.liu.mq.utils.RabbitMqUtils;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;

/**
 * @author lms
 * @date 2021-09-16 - 8:41
 *
 * 成为死信队列的三大来源？
 *  1.消息被拒绝接收
 *  2.消息TTL过期
 *  3.队列到达最大长度
 */
public class Producer {

    private static final String NORMAL_EXCHANGE = "normal_exchange";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        // 创建交换机
        channel.exchangeDeclare(NORMAL_EXCHANGE, BuiltinExchangeType.DIRECT);

        // 死信队列的方式2：消息达到过期时间
        // 设置每条信息的过期时间为10秒(ttl)
        AMQP.BasicProperties properties = new AMQP.BasicProperties().builder().expiration("10000").build();

        for (int i = 0; i < 10; i++) {
            // 方式1：模拟消息被拒绝
            String message = "info" + i;
            // 发送消息（设置了每条消息的过期时间）
            // channel.basicPublish(NORMAL_EXCHANGE, "zhangsan", properties, message.getBytes("utf-8"));
            // 设置队列的最大长度数（超出部分将会放置到死信队列中）
            channel.basicPublish(NORMAL_EXCHANGE, "zhangsan", null, message.getBytes("utf-8"));
        }
        System.out.println("消息发送成功~");
    }
}
