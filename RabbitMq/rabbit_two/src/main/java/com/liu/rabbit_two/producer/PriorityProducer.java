package com.liu.rabbit_two.producer;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.HashMap;

/**
 * @author lms
 * @date 2021-09-24 - 10:29
 */
public class PriorityProducer {

    // 定义优先队列的名称
    private static final String PRIORITY_QUEUE = "priority_queue";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.115.129");
        factory.setUsername("guest");
        factory.setPassword("guest");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        // 设置队列，并声明为优先级队列，优先级别为10
        HashMap<String, Object> arguments = new HashMap<>();
        arguments.put("x-max-priority", 10);
        // 创建队列
        channel.queueDeclare(PRIORITY_QUEUE, true, false, false, arguments);

        for (int i = 1; i < 11; i++) {
            String message = "info " + i;
            // 设置优先级最高为5，先消费优先级为5的信息，其他的消息优先级不设置，即为默认的优先级
            if (i == 5){
                AMQP.BasicProperties properties =
                        new AMQP.BasicProperties().builder().priority(5).build();
                channel.basicPublish("", PRIORITY_QUEUE, properties, message.getBytes());
            }else {
                channel.basicPublish("", PRIORITY_QUEUE, null, message.getBytes());
            }
        }
        System.out.println("消息发送完毕!");
        // 关闭连接
    }
}
