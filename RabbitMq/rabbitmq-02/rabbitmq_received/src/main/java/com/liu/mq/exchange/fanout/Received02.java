package com.liu.mq.exchange.fanout;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
/**
 * @author lms
 * @date 2021-05-27 - 10:45
 */
public class Received02 {
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

            /**
             * 由于fanout类型的交换机的消息是类似于广播方式，它不需要绑定RoutingKey
             * 而又可能是会有很多个消费者来接收这个交换机中的数据，因此我们创建队列时
             * 要创建一个随机的队列名称
             */
            String queue = channel.queueDeclare().getQueue();
            //创建交换机：使用fanout的类型
            channel.exchangeDeclare("fanoutExchange", "fanout", true);
            // 将队列绑定到交换机
            channel.queueBind(queue, "fanoutExchange", "");
            /**
             * 监听某个队列，并获取队列中的消息
             * 注意：当前被监听的队列必须确定被创建并且存在
             */
            channel.basicConsume(queue, true, "", new DefaultConsumer(channel){
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                           byte[] body) throws IOException {
                    String message = new String(body);
                    System.out.println("消费者02 = " + message);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
