package com.liu.mq.confirm;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author lms
 * @date 2021-05-26 - 20:43
 */
public class ConfirmsOrDieSend {

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
            channel.queueDeclare("direcConfirmQueue", true, false, false, null);
            /**
             * 创建交换机：
             *  参数1：为交换机的名称，任意
             *  参数2：交换机的类型，类型有direct，fanout，topic， headers
             *  参数3：是否为持久化的交换机
             */
            channel.exchangeDeclare("confirmExchange", "direct", true);

            /**
             * 将队列绑定到交换机
             * 参数1：队列的名字
             * 参数2：交换机的名字
             * 参数3,：为消息的routingKey，即bingdingkey
             * 注意：
             *      1.在进行队列和交换机绑定时必须确保交换机和队列已经成功的声明
             */
            channel.queueBind("direcConfirmQueue", "confirmExchange", "confirmRoutingKey");

            /**
             * 发送消息到指定的队列中：
             *  参数1：交换机的名字
             *  参数2：为消息的RoutingKey，如果这个消息的RoutingKey和某个队列与交换机绑定的RoutingKey一致
             *      那么这个消息就会别发送到这个队列中
             *  注意：
             *      发送消息时必须确保交换机已经创建并且确保已经正确的绑定到某个队列中
             */
            String message = "confirm实现的消息发送";
            // 开启发送者确认模式
            channel.confirmSelect();
            channel.basicPublish("confirmExchange", "confirmRoutingKey", null, message.getBytes("utf-8"));
            /**
             * waitForConfirmsOrDie() 批量信息确认，他会同时向服务器中确认之前当前通道中发送的消息，
             * 该方法没有返回值，如果服务器中有一条信息没有发送成功，就都不会成功
             * 消息确认发送失败，可能是有消息没有没有发送成功，我们需要进行补发
             * 如果无法向服务器获取确认消息，那么方法就有可能出现异常，
             * 这个时候可以为方法中添加一个参数，timeout，用于等待服务器的确认时间，抛出异常，表示确认
             * 失败需要补发消息
             * 注意：
             *   批量嘻嘻确认的速度比普通的消息确认要快，但是如果出现了消息补发的情况，
             *   都必须将所有所有的信息进行重新的补发
             */
            // 批量确认发送的方式
            channel.waitForConfirmsOrDie();
            System.out.println("消息发送成功");
        } catch (Exception e) {
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
