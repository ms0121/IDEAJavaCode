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
public class ConfirmSend {

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
             * 阻塞线程等待服务返回，用于是否消费发送成功，如果服务发送成功则返回true，否则为false
             * 可以为这个方法指定一个毫秒时间用于确定我们需要等待的服务时间的超时时间
             * 若超过了指定的时间以后就会抛出异常，表示服务器出现了问题，需要补发消息
             * 蒋茜茜缓存到redis中稍后利用定时任务补发
             * 无论是返回false还是抛出异常都有可能发送成功有可能没有发送成功
             * 如果我们要求这个消息一定要发送到队列中，那我们可以采用消息补发
             * 所谓部分就是重新发送一个信息，可以使用递归方法或者redis+定时任务来实现补发
             */
            // 普通确认方式（一个一个的确认发送）
            boolean flag = channel.waitForConfirms();
            System.out.println("消息发送成功" + flag);
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
