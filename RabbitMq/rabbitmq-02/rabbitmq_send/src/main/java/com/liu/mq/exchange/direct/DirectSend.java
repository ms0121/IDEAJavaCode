package com.liu.mq.exchange.direct;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author lms
 * @date 2021-05-27 - 10:25
 */
public class DirectSend {

    public static void main(String[] args) {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.115.128");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");

        Connection connection = null;
        Channel channel = null;

        try {
            connection = connectionFactory.newConnection();
            channel = connection.createChannel();

            // 创建队列
            channel.queueDeclare("directQueue", true, false, false, null);
            /**
             * 创建交换机：
             *  参数1：为交换机的名称，任意
             *  参数2：交换机的类型，类型有direct，fanout，topic， headers
             *  参数3：是否为持久化的交换机
             */
            channel.exchangeDeclare("directExchange", "direct", true);

            /**
             * 将队列绑定到交换机
             * 参数1：队列的名字
             * 参数2：交换机的名字
             * 参数3,：为消息的routingKey，即bingdingkey
             * 注意：
             *      1.在进行队列和交换机绑定时必须确保交换机和队列已经成功的声明
             */
            channel.queueBind("directQueue", "directExchange", "directRoutingKey");

            /**
             * 发送消息到指定的队列中：
             *  参数1：交换机的名字
             *  参数2：为消息的RoutingKey，如果这个消息的RoutingKey和某个队列与交换机绑定的RoutingKey一致
             *      那么这个消息就会别发送到这个队列中
             *
             *  注意：
             *      发送消息时必须确保交换机已经创建并且确保已经正确的绑定到某个队列中
             */
            String message = "direct实现的消息发送";
            channel.basicPublish("directExchange", "directRoutingKey", null, message.getBytes("utf-8"));
            System.out.println("消息发送成功");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } finally {
            if (channel != null ){
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null){
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
