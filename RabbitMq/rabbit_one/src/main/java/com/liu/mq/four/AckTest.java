package com.liu.mq.four;

import com.liu.mq.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

/**
 * @author lms
 * @date 2021-09-14 - 20:11
 */
public class AckTest {
    public static void main(String[] args) throws Exception {
        // 单个确认模式
//        AckTest.test01();

        // 批量确认
//        AckTest.test02();



    }

    // 单一发布确认
    public static void test01() throws Exception {
        Channel channel = RabbitMqUtils.getChannel();

        // 队列名字
        String queueName = UUID.randomUUID().toString().substring(0, 4);
        // 创建队列
        channel.queueDeclare(queueName, false, false, false, null);

        // 开启确认模式
        channel.confirmSelect();

        // 计算时间
        long start = System.currentTimeMillis();

        // 发送1000条信息到指定mq中
        for (int i = 0; i < 1000; i++) {
            String message = i + "";
            // 发送消息
            channel.basicPublish("", queueName, null, message.getBytes());
            // 每收到一个消息都进行确认
            boolean flag = channel.waitForConfirms();
            if (flag) {
                System.out.println("消息发送成功!!");
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("单个确认 -- 总耗时： " + (end - start));
    }


    // 批量发布确认
    public static void test02() throws IOException, TimeoutException, InterruptedException {
        Channel channel = RabbitMqUtils.getChannel();
        String queueName = UUID.randomUUID().toString().substring(0,4);
        // 队列名字，不持久化，
        channel.queueDeclare(queueName, false, false, false, null);

        // 开启确认模式
        channel.confirmSelect();

        // 计算时间
        long start = System.currentTimeMillis();

        // 发送1000条信息到指定mq中
        for (int i = 0; i < 1000; i++) {
            String message = i + "";
            // 发送消息
            channel.basicPublish("", queueName, null, message.getBytes());
            // 批量确认
            if (i % 100 == 0){
                channel.waitForConfirms();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("批量确认 -- 总耗时： " + (end - start));
    }



}
