package com.liu.mq.seven;

import com.liu.mq.utils.RabbitMqUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

/**
 * @author lms
 * @date 2021-09-15 - 9:05
 * topic模式
 */
public class TopicConsumer01 {
    // 设置交换机的名称
    private static final String exchangeName = "topic_logs";

    public static void main(String[] args) throws Exception {
        // 获取信道
        Channel channel = RabbitMqUtils.getChannel();
        // 创建交换机并设置为topic模式
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.TOPIC);
        String queueName = "Q1";
        // 创建队列,队列名字，不持久化，不自动删除，无其他参数
        channel.queueDeclare(queueName, false, false, false, null);
        // 绑定队列和交换机
        channel.queueBind(queueName, exchangeName, "*.orange.*");

        System.out.println("bingdingkey是： *.orange.*");
        System.out.println("Q1开始接收消息.............");
        // 消费成功的回调函数，
        DeliverCallback deliverCallback = (s, delivery) -> {
            String message = new String(delivery.getBody(), "utf-8");
            // delivery.getEnvelope(): 从里面可以获取交换机，队列，bingdingkey的值
            //  delivery.getEnvelope().getRoutingKey()： 获取交换机和队列之间的绑定key
            System.out.println("接收队列: " + queueName + "绑定键: " + delivery.getEnvelope().getRoutingKey() +
                    ", 消息:" + message);
        };

        // 消费消息，队列名字，自动应答，消费成功的回调函数，消费失败的回调函数
        channel.basicConsume(queueName, true, deliverCallback, s -> { });
    }
}
