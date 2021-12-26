package com.liu.mq.three;

import com.liu.mq.utils.RabbitMqUtils;
import com.liu.mq.utils.SleepTime;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author lms
 * @date 2021-09-14 - 9:35
 * 公平轮询的机制
 * 不设置队列和消息的持久化
 */
public class Worker01 {

    private static final String queue_name = "ack_queue";

    public static void main(String[] args) throws IOException, TimeoutException {

        Channel channel = RabbitMqUtils.getChannel();


        DeliverCallback deliverCallback = (s, delivery) -> {
            String message = new String(delivery.getBody(), "utf-8");
            System.out.println("worker01 - 延迟1秒进行消费: ");
            SleepTime.sleepTime(1);
            System.out.println("消费的消息是: " + message);

            /**
             * 手动应答：
             * 参数1：对消费的消息进行标志是否消费 tag
             *      所以延迟的消费者会很慢的进行消费，并最终做出应答的机制
             * 参数2：是否批量应答，false不批量应答信道中的消息，true，批量应答（可能造成消息的丢失）
             */
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        };

        boolean ack = false;
        // 手动应答
        channel.basicConsume(queue_name, ack, deliverCallback, (s) -> {
            System.out.println("消费者取消了消费: " + s);
        });
    }
}
