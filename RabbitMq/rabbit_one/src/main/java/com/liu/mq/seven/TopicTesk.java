package com.liu.mq.seven;

import com.liu.mq.utils.RabbitMqUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @author lms
 * @date 2021-09-15 - 9:17
 */
public class TopicTesk {
    // 设置交换机的名称
    private static final String exchangeName = "topic_logs";

    public static void main(String[] args) throws Exception{
        Channel channel = RabbitMqUtils.getChannel();
        // 创建交换机并指定其类型
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.TOPIC);

        /**
         * Q1-->绑定的是
         *      中间带 orange 带 3 个单词的字符串(*.orange.*)
         * Q2-->绑定的是
         *      最后一个单词是 rabbit 的 3 个单词(*.*.rabbit)
         *      第一个单词是 lazy 的多个单词(lazy.#)
         *
         */
        Map<String, String> bindingKeyMap = new HashMap<>();
        bindingKeyMap.put("quick.orange.rabbit"," 被队列 Q1Q2  接收到");
        bindingKeyMap.put("lazy.orange.elephant"," 被队列 Q1Q2  接收到");
        bindingKeyMap.put("quick.orange.fox"," 被队列 Q1  接收到");
        bindingKeyMap.put("lazy.brown.fox"," 被队列 Q2  接收到");

        bindingKeyMap.put("lazy.pink.rabbit"," 虽然满足两个绑定但只被队列 Q2  接收一次");
        bindingKeyMap.put("quick.brown.fox"," 不匹配任何绑定不会被任何队列接收到会被丢弃");
        bindingKeyMap.put("quick.orange.male.rabbit"," 是四个单词不匹配任何绑定会被丢弃");
        bindingKeyMap.put("lazy.orange.male.rabbit"," 是四个单词但匹配 Q2");

        for (Map.Entry<String, String> bindingKeyEntry : bindingKeyMap.entrySet()) {
            String bindingKey = bindingKeyEntry.getKey();
            String message = bindingKeyEntry.getValue();

            channel.basicPublish(exchangeName, bindingKey, null, message.getBytes("utf-8"));
        }
        System.out.println("topic消息发送完毕~~~~");
    }
}
