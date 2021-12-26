package com.liu.mq.three;

import com.liu.mq.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * @author lms
 * @date 2021-09-14 - 9:20
 * 公平的轮序分发原则
 * 目的：验证消息在手动应答的时候是不丢失的，如果未消费成功，则会将消息重新放回到队列中，
 *      那么另一个队列将会消费队列中未被消费的消息
 */
public class Task {

    private static final String queue_name = "ack_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMqUtils.getChannel();
        // 创建队列
        channel.queueDeclare(queue_name, false, false, false, null);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String messsage = scanner.next();
            // 发送消息
            channel.basicPublish("", queue_name, null, messsage.getBytes("utf-8"));
            System.out.println("消息发送成功!! " + messsage);
        }
    }
}
