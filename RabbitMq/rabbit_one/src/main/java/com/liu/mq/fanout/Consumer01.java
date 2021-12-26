package com.liu.mq.fanout;

import com.liu.mq.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

/**
 * @author lms
 * @date 2021-09-14 - 21:54
 */
public class Consumer01 {

    // 定义交换机的名称
    private static  final String exchangeName = "logs";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        // 创建一个交换机，并指定交换机的类型
        channel.exchangeDeclare(exchangeName, "fanout");
        /**
         * 生成一个临时的队列，队列的名字是随机的，
         * 当消费者断开连接的时候，队列会自动进行删除
         */
        String queueName = channel.queueDeclare().getQueue();
        // 把该临时队列绑定到我们的exchange中，其中bingdingkey为空字符串
        channel.queueBind(queueName, exchangeName, "");
        System.out.println("Consumer-1 正在等待生产者的消息。。。。。。。。");

        // 成功接收消息的回调函数
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "utf-8");
            System.out.println("message = " + message);
        };
        channel.basicConsume(queueName, true, deliverCallback, s-> { });

    }
}
