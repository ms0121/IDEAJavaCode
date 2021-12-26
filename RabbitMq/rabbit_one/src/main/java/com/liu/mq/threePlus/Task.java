package com.liu.mq.threePlus;

import com.liu.mq.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * @author lms
 * @date 2021-09-14 - 9:20
 * 目的：验证消息在手动应答的时候是不丢失的，如果未消费成功，则会将消息重新放回到队列中，
 *      那么另一个队列将会消费队列中未被消费的消息
 */
public class Task {

    private static final String queue_name = "ack_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMqUtils.getChannel();
        // 创建队列,并将队列设置为持久化(true)，即rabbitmq重启还会存在
        channel.queueDeclare(queue_name, true, false, false, null);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String messsage = scanner.next();
            // 发送消息,同样设置发送的消息也为持久化 (MessageProperties.PERSISTENT_TEXT_PLAIN)
            channel.basicPublish("", queue_name, MessageProperties.PERSISTENT_TEXT_PLAIN, messsage.getBytes("utf-8"));
            System.out.println("消息发送成功!! " + messsage);
        }
    }
}
