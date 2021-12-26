package com.liu.mq.two;

import com.liu.mq.utils.RabbitMqUtils;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author lms
 * @date 2021-09-14 - 8:24
 */
public class Worker02 {

    // 指定队列的名称
    private static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMqUtils.getChannel();

        // 成功消费的回调函数：函数式接口（个人理解）
        DeliverCallback deliverCallback = new DeliverCallback() {
            /**
             * @param s
             * @param delivery  调用成功接收到的消息（包函请求头，消息）
             * @throws IOException
             */
            @Override
            public void handle(String s, Delivery delivery) throws IOException {
                System.out.println("worker02 = " + new String(delivery.getBody(),"utf-8"));
            }
        };

        // 取消消费之后的回调函数
        CancelCallback cancelCallback = new CancelCallback() {
            @Override
            public void handle(String s) throws IOException {
                System.out.println("s = " + s);
            }
        };
        /**
         * 消费消息：
         * 参数1：消费指定的队列
         * 参数2: 是否自动应答
         * 参数3：消费成功之后的回调函数
         * 参数4：取消消费的回调函数
         */
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);
    }
}
