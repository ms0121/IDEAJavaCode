package com.liu.mq.direct;

import com.liu.mq.utils.RabbitMqUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;

import java.io.IOException;

/**
 * @author lms
 * @date 2021-09-14 - 22:54
 */
public class Consumer01 {

    // 定义交换机的名称
    private static final String EXCHANGE_NAME = "direct_logs";
    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        // 指定交换机的类型为direct
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
        // 指定队列的名称，并指定多个routingkey
        String queueName = "console";
        // 队列名称，不持久化，不共享，不自动删除，其他参数设置
        channel.queueDeclare(queueName, false, false, false, null);
        //绑定交换机,多个RoutingKey
        channel.queueBind(queueName, EXCHANGE_NAME, "info");
        channel.queueBind(queueName, EXCHANGE_NAME, "warning");

        System.out.println("consumer-01收到消费的信息..........");
        DeliverCallback deliverCallback = (s,delivery) -> {
            String message = new String(delivery.getBody(), "utf-8");
            System.out.println("message = " + message);
        };

        // 队列的名字，自动应答，成功的回调函数，失败的回调函数
        channel.basicConsume(queueName, true, deliverCallback, s->{});

    }
}
