package com.liu.rabbit_two.consumer;

import com.rabbitmq.client.*;

/**
 * @author lms
 * @date 2021-09-24 - 10:45
 */
public class PriorityConsumer {
    private static final String PRIORITY_QUEUE = "priority_queue";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.115.129");
        factory.setUsername("guest");
        factory.setPassword("guest");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();


        // 推送的消息如何进行消费的接口回调
        DeliverCallback deliverCallback = (String s, Delivery delivery) -> {
            String message = new String(delivery.getBody());
            System.out.println("message = " + message);
        };

        // 取消消费的一个回调函数接口，如在消费的时候队列被删除了
        CancelCallback cancelCallback = (String s) -> {
            System.out.println("消息消费被中断了..........");
        };
        channel.basicConsume(PRIORITY_QUEUE, true, deliverCallback, cancelCallback);
    }
}
