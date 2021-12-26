package com.liu.mq.exchange.topic;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author lms
 * @date 2021-05-27 - 10:45
 */
public class Received03 {
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

            channel.queueDeclare("topicQueue03", true, false, false, null);
            //创建交换机：使用fanout的类型
            channel.exchangeDeclare("topicExchange", "topic", true);
            // 将队列绑定到交换机，设置相应的RoutingKey
            channel.queueBind("topicQueue03", "topicExchange", "aa.#");
            /**
             * 监听某个队列，并获取队列中的消息
             * 注意：当前被监听的队列必须确定被创建并且存在
             */
            channel.basicConsume("topicQueue03", true, "", new DefaultConsumer(channel){
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                           byte[] body) throws IOException {
                    String message = new String(body);
                    System.out.println("消费者01 aa.# = " + message);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
