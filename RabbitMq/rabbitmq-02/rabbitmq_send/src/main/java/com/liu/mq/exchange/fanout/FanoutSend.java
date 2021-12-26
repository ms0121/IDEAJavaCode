package com.liu.mq.exchange.fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author lms
 * @date 2021-05-27 - 10:25
 */
public class FanoutSend {

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
             * 由于使用了Fanout类型的交换机，因此消息的接收方肯定会有多个，因此不建议在消息
             * 发送时创建队列，以及绑定交换机，建议在消费者中创建队列并绑定交换机
             * 但是发送消息是至少应该确保交换机的存在
             *
             */
//            channel.queueDeclare("fanoutQueue", true, false, false, null);
//            channel.queueBind("fanoutQueue", "directExchange", "directRoutingKey");
            channel.exchangeDeclare("fanoutExchange", "fanout", true);

            String message = "fanout实现的消息发送";
            channel.basicPublish("fanoutExchange", "",null, message.getBytes("utf-8"));
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
