package com.liu.mq.one;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author lms
 * @date 2021-09-13 - 22:14
 * 生产者向消息队列中发送消息
 */
public class Producer {

    // 消息队列的名称
    public static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 1.创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        // 设置mq的连接信息
        factory.setHost("192.168.115.129");
        factory.setUsername("guest");
        factory.setPassword("guest");
        // 2.从工厂中获取一个连接connection
        Connection connection = factory.newConnection();
        // 3.从connection中获取一个channel
        Channel channel = connection.createChannel();
        /**
         * 生成一个队列：
         *  参数1：队列名称
         *  参数2：队列里面的消息是否持久化，默认消息存储在内存中
         *  参数3：该队列是否只供一个消费者进行消费，是否共享，true表示可以多个消费者共享
         *  参数4：是否自动删除，最后一个消费者消费断开连接以后，该队列是否自动删除，true 自动删除
         *  参数5：其他参数
         */
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        // 设置要发送的消息
        String message = "hello RabbitMQ";

        /**
         * 发送一个消息
         * 参数1、消息发送到哪个交换机
         * 参数2. 路由key是哪个
         * 参数3. 其他的参数信息
         * 参数4. 发送消息的消息体
         */
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println("消息发送完毕!");

        // 4. 关闭连接
//        channel.close();
//        connection.close();
    }
}
