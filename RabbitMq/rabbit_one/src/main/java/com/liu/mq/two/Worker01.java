package com.liu.mq.two;

import com.liu.mq.utils.RabbitMqUtils;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author lms
 * @date 2021-09-14 - 8:12
 * 接收消息
 */
public class Worker01 {
    // 队列的名称
    public static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {

        // 获取信道
        Channel channel = RabbitMqUtils.getChannel();

        // 成功消费返回的函数(函数式接口)
        // param s
        // param delivery  调用成功接收到的消息（包函请求头，消息）
        DeliverCallback deliverCallback = (s, delivery) -> {
            String message = new String(delivery.getBody(), "utf-8");
            System.out.println("woker01:  " + message);
        };

        // 取消消费调用的函数
        CancelCallback cancelCallback = (s) -> {
            System.out.println("取消消费 = " + s);
        };

        // 消费消息
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);
    }
}
