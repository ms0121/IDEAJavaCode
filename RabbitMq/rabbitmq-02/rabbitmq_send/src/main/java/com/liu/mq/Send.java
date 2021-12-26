package com.liu.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * @author lms
 * @date 2021-05-26 - 20:43
 */
public class Send {

    public static void main(String[] args) {

        // 1.获取连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        // 设置连接工厂的初始条件
        connectionFactory.setHost("192.168.115.128");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
//        connectionFactory.setVirtualHost("/");    // 访问的根路径

        Connection connection = null;
        Channel channel = null;

        try {
            // 2. 获取具体的某个连接
            connection = connectionFactory.newConnection();
            // 3. 从connection中获取channel
            channel = connection.createChannel();
            /**
             * 声明一个队列：
             *  参数1：为队列取名字
             *  参数2：是否为持久化队列
             *  参数3：是否排外，如果排外，这个队列只允许表示一个消费者监听
             *  参数4：是否自动删除，如果为true，则表示当队列中没有消息，也没有消费者的时候就会自动的删除这个队列
             *  参数5：为队列的一些属性设置通常为null即可
             *
             *  注意：
             *      1.声明队列时，如果当前的队列名称存在，则放弃声明，如果队列不存在则会声明一个新的队列
             *      2.队列名可以取任意值，但是要与消息接收是完全一致
             *      3.这行对吗可有可无，但是一定要在发送消息前确认队列名已经mq中，否则就会出现问题
             */
            channel.queueDeclare("queue2", true, false, false, null);
            String message = "我是rabbitmq的消息";
            /**
             * 发送消息到队列中
             * 参数1：为交换机的名字，这里为空字符串表示不使用交换机的方式
             * 参数2：为队列名或RoutingKey，当指定了交换机名称以后，这个值就是routingkey，
             * 参数3：为消息属性，通常为空即可
             * 参数4：为具体的数据的字节数组
             */
            channel.basicPublish("", "queue2", null, message.getBytes("utf-8"));
            System.out.println("消息发送成功！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (channel != null){
                try {
                    channel.close();
                } catch (Exception e) {
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
