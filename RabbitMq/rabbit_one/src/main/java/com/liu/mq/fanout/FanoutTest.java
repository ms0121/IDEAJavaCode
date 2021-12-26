package com.liu.mq.fanout;

import com.liu.mq.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * @author lms
 * @date 2021-09-14 - 21:53
 */
public class FanoutTest {

    // 定义交换机的名称, 可以不用再去生成一个交换机，因为消费者已经生成有了
    private static  final String exchangeName = "logs";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMqUtils.getChannel();
        // 生成交换机，并指定交换机的类型
        channel.exchangeDeclare(exchangeName, "fanout");

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String message = scanner.next();
            // 消息发送
            channel.basicPublish(exchangeName, "", null, message.getBytes("utf-8"));
        }
    }
}
