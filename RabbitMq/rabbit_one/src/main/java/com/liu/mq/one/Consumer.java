package com.liu.mq.one;


import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author lms
 * @date 2021-09-13 - 22:14
 * 消费者的队列名应该和生产者的保持一致
 */
public class Consumer {

    // 消息队列的名称
    public static final String QUEUE_NAME = "hello";

    // 消费消息
    public static void main(String[] args) throws IOException, TimeoutException {
        // 创建工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.115.129");
        factory.setUsername("guest");
        factory.setPassword("guest");
        // 获取某一个连接
        Connection connection = factory.newConnection();
        // 创建一个信道（通道）
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

        /**
         * 消费者消费消息:
         * 参数1：消费哪个队列
         * 参数2：消费成功之后是否要自动应答，true代表自动应答，false手动应答
         * 参数3：消费者成功消费的回调
         * 参数4：消费者取消消费的回调
         */
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);

        // 4. 关闭连接
//        channel.close();
//        connection.close();
    }
}















