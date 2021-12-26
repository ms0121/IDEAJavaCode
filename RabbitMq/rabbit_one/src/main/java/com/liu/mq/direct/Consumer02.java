package com.liu.mq.direct;

import com.liu.mq.utils.RabbitMqUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

/**
 * @author lms
 * @date 2021-09-14 - 23:03
 */
public class Consumer02 {
    // 定义交换机的名称
    private static final String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        // 创建交换机，并指定为direct模式
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
        String queueName = "disk";
        // 生成队列，队列的名字，不持久化，不共享，不自动删除，其他参数
        channel.queueDeclare(queueName, false, false, false, null);
        // 绑定交换机
        channel.queueBind(queueName, EXCHANGE_NAME, "error");

        System.out.println("consumer-02收到消费的信息..........");
        DeliverCallback deliverCallback = (s, delivery) -> {
            String message = new String(delivery.getBody(), "utf-8");
            System.out.println("message = " + message);
        };

        // 队列的名字，自动应答，成功的回调函数，失败的回调函数
        channel.basicConsume(queueName, true, deliverCallback, s->{});
    }
}
