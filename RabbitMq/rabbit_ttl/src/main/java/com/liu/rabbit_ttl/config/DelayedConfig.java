package com.liu.rabbit_ttl.config;



import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * @author lms
 * @date 2021-09-24 - 8:04
 * 基于插件的延迟交换机
 */
@Configuration
public class DelayedConfig {

    // 延迟交换机
    public static final String DELAYED_EXCHANGE_NAME = "delayed.exchange";
    // 延迟队列
    public static final String DELAYED_QUEUE_NAME = "delayed.queue";
    // 延迟
    public static final String DELAYED_ROUTING_KEY = "delayed.routing.key";

    // 自定义的延迟交换机
    @Bean
    public CustomExchange delayedExchange(){
        HashMap<String, Object> arguments = new HashMap<>();
        // 自定义交换机的类型(还是direct模式的交换机)
        arguments.put("x-delayed-type", "direct");
        return new CustomExchange(DELAYED_EXCHANGE_NAME, "x-delayed-message",
                true, true, arguments);
    }

    // 创建队列
    @Bean
    public Queue delayedQueue(){
        return new Queue(DELAYED_QUEUE_NAME);
    }

    // 绑定交换机和队列
    @Bean
    public Binding bindingExchange(@Qualifier("delayedQueue") Queue queue,
                                   @Qualifier("delayedExchange") CustomExchange exchange){
        // 通过路由key将延迟交换机和队列进行绑定
        return BindingBuilder.bind(queue).to(exchange).with(DELAYED_ROUTING_KEY).noargs();
    }
}
