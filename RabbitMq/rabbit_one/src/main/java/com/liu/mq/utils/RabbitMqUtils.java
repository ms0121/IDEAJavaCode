package com.liu.mq.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author lms
 * @date 2021-09-14 - 8:08
 */
public class RabbitMqUtils {

    public static Channel getChannel() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.115.129");
        factory.setUsername("guest");
        factory.setPassword("guest");

        // 获取连接
        Connection connection = factory.newConnection();
        // 获取信道
        return connection.createChannel();
    }

//    public static void main(String[] args) throws IOException, TimeoutException {
//        Channel channel = getChannel();
//        System.out.println("连接成功~");
//    }
}
