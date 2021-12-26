package com.liu.mq.fanout;

import com.liu.mq.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;

import java.io.IOException;

/**
 * @author lms
 * @date 2021-09-14 - 22:05
 */
public class Consumer02 {

    // 定义交换机的名称
    private static  final String exchangeName = "logs";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        // 指定交换机的名字
        channel.exchangeDeclare(exchangeName, "fanout");
        // 获取队列
        String queueName = channel.queueDeclare().getQueue();
        // 绑定队列和交换机,使用空字符串作为bingdingkey
        channel.queueBind(queueName, exchangeName, "");
        // 成功后调用的回调函数
        DeliverCallback deliverCallback = new DeliverCallback() {
            @Override
            public void handle(String s, Delivery delivery) throws IOException {
                String message = new String(delivery.getBody(), "utf-8");
                System.out.println("message = " + message);
            }
        };
        // 消费消息
        channel.basicConsume(queueName, true, deliverCallback, s -> {});
    }
}
