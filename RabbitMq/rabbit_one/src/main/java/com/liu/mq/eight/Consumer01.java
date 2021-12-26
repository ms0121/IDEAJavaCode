package com.liu.mq.eight;

import com.liu.mq.utils.RabbitMqUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;

import java.io.IOException;
import java.util.HashMap;
import java.util.spi.CalendarNameProvider;

/**
 * @author lms
 * @date 2021-09-16 - 7:57
 */
public class Consumer01 {

    // 普通交换机和普通队列
    private static final String NORMAL_EXCHANGE = "normal_exchange";
    private static final String NORMAL_QUEUE = "normal_queue";

    // 死信交换机死信队列
    private static final String DEAD_EXCHANGE = "dead_exchange";
    private static final String DEAD_QUEUE = "dead_queue";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        // 创建普通交换机
        channel.exchangeDeclare(NORMAL_EXCHANGE, BuiltinExchangeType.DIRECT);
        // 创建死信交换机
        channel.exchangeDeclare(DEAD_EXCHANGE, BuiltinExchangeType.DIRECT);


        // 创建队列的第五个参数设置
        HashMap<String, Object> arguments = new HashMap<>();
        // 设置消息的过期时间（一般在生产者部分进行设置）
        // 设置产生死信之后发送到的交换机
        arguments.put("x-dead-letter-exchange", DEAD_EXCHANGE);
        // 设置死信的路由key
        arguments.put("x-dead-letter-routing-key", "lisi");

        // 死信队列的方式3：达到队列的最大长度
        // 设置正常队列的长度限制（超出部分将会放入到死信队列中）
        // arguments.put("x-max-length", 6);

        // 创建普通队列
        channel.queueDeclare(NORMAL_QUEUE, false, false, false, arguments);
        // 创建死信队列
        channel.queueDeclare(DEAD_QUEUE, false, false, false, null);


        // 绑定交换机和队列
        // 队列名，交换机名，路由key
        channel.queueBind(NORMAL_QUEUE, NORMAL_EXCHANGE, "zhangsan");
        channel.queueBind(DEAD_QUEUE, DEAD_EXCHANGE, "lisi");

        System.out.println("正在等待接收消息..........");
        // 消费成功的回调函数(函数式接口，可以直接使用lambda表达式进行设置)
        DeliverCallback deliverCallback = new DeliverCallback() {
            @Override
            public void handle(String s, Delivery delivery) throws IOException {
                String message = new String(delivery.getBody(), "utf-8");
                if (message.equalsIgnoreCase("info5")){
                    System.out.println("当前消息已经被拒绝接收: " + delivery.getEnvelope().getDeliveryTag() + "，消息是: " + message);
                    // 设置当前消息被消费者拒绝接收,不放回队列中
                    channel.basicReject(delivery.getEnvelope().getDeliveryTag(), false);
                }else {
                    System.out.println("Consumer01消费的消息是： " + message);
                    // 手动应答,设置已经消费的消息，不批量应答
                    channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
                }
            }
        };
        // 消费者01进行消费消息(模拟消息被拒绝接收，不能设置为自动应答)
        // 消费的队列名，是否自动应答，消费成功的回调函数，取消消费的回调函数
        channel.basicConsume(NORMAL_QUEUE, false, deliverCallback ,s -> {});
    }
}
