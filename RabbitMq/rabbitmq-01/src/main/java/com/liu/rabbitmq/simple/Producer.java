package com.liu.rabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;

/**
 * @author lms
 * @date 2021-05-25 - 10:57
 * simple模式下的simple模式的设置
 */

public class Producer {

    public static void main(String[] args) {
        // 所有的中间件技术都是基于tcp/ip协议的基础上构建新型的协议规范，只不过rabbitmq
        // 遵循的是amqp协议
//        1.创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();

//       连接工厂的基础设置
        connectionFactory.setHost("192.168.115.128");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");

        Connection connection = null;
        Channel channel = null;

        try {
//        2.创建connection连接 (在连接工厂中创建一个连接)
            connection = connectionFactory.newConnection("producer");
//        3、通过连接获取通道channel
            channel = connection.createChannel();
//        4.通过创建交换机，声明队列，绑定关系，路由key，发送消息，和接收消息
//          设置通道中队列的名字
            String queueName = "queue1";
            /**
             * 队列的名称
             * 是否要持久化，所谓持久化就是消息是否存盘，如果为false非持久化，true为持久化
             * 排他性，是否独立存在
             * 是否自动删除，随着最后一个消息完毕以后是否把队列中的消息进行删除
             * 携带附属参数
             */
            channel.queueDeclare(queueName, false, false, false, null);
//        5。发送消息内容
            String message = "hello rabbitmq";
//        6.发送消息给队列
            channel.basicPublish("", queueName, null, message.getBytes());
            System.out.println("消息发送成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
//        7、关闭通道
            if (channel != null && channel.isOpen()){
                try {
                    channel.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
//        8.关闭连接
            if(connection != null && connection.isOpen()){
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
