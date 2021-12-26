package com.liu.mq.two;

import com.liu.mq.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * @author lms
 * @date 2021-09-14 - 8:36
 * 模拟轮询分发
 */
public class Task {

    // 指定队列的名字
    private static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 获取信道
        Channel channel = RabbitMqUtils.getChannel();
        // 获取输入流
        Scanner scanner = new Scanner(System.in);
        // scanner.hasNext(): 还有输入的情况下为真
        while (scanner.hasNext()) {
            /**
             * 创建队列：
             *  参数1：队列名称
             *  参数2：队列中的消息是否持久化，默认是保存在内存中
             *  参数3：该队列是是否只供一个消费者，是否共享，true表示多个消费者可以消费
             *  参数4：是否自动删除，当消费者断开连接后自动删除
             *  参数5：其他参数
             */
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            // 发送的消息
            String message = scanner.next();
            /**
             * 发送消息：
             * 参数1、消息发送到哪个交换机
             * 参数2. 路由key是哪个(交换机和队列之间对的绑定使用RoutingKey)
             * 参数3. 其他的参数信息
             * 参数4. 发送消息的消息体
             */
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes("utf-8"));
            System.out.println("消息发送成功： " + message);
        }
    }
}
















