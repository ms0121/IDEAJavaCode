package com.liu.mq.eight;

import com.liu.mq.utils.RabbitMqUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;

import java.io.IOException;

/**
 * @author lms
 * @date 2021-09-16 - 9:02
 */
public class Consumer02 {
    // 交换机的名称和队列名
    private static final String DEAD_EXCHANGE = "dead_exchange";
    private static final String DEAD_QUEUE = "dead_queue";

    public static void main(String[] args) throws Exception{
        Channel channel = RabbitMqUtils.getChannel();
        // 设置交换机的类型
//        channel.exchangeDeclare(DEAD_EXCHANGE, BuiltinExchangeType.DIRECT);
//        channel.queueDeclare(DEAD_QUEUE, false, false, false, null);

        // 绑定交换机和队列
//        channel.queueBind(DEAD_QUEUE, DEAD_EXCHANGE, "lisi");

        System.out.println("正在等待消息............");
        // 消费成功的回调函数
        DeliverCallback deliverCallback = (s, delivery) -> {
            String message = new String(delivery.getBody(), "utf-8");
            System.out.println("consumer02消费的消息是:  " + message + " ，使用的交换机是： "
                    + delivery.getEnvelope().getExchange() + "，路由key是: " + delivery.getEnvelope().getRoutingKey());
        };

        channel.basicConsume(DEAD_QUEUE, false, deliverCallback, consumerTag->{});

    }

}
