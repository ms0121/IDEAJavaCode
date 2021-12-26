package com.liu.bootmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lms
 * @date 2021-05-27 - 20:58
 */

@Configuration
public class DirectReceivedConfig {

    // 向容器中注入Exchange交换机，
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("bootDirectExchange");
    }

    // 注入Queue队列
    @Bean
    public Queue directQueue(){
        return new Queue("bootDirectQueue");
    }

    /**
     * 配置交换机和队列之间的绑定
     * @param directExchange 需要绑定的交换机名称，参数名必须和@Bean中的方法名完全相同，这样子才能进行自动注入(因为方法名就是该类在容器中创建的对象)
     * @param directQueue 需要绑定的队列名称，参数名必须和@Bean中的方法名完全相同，这样子才能进行自动注入
     * @return
     */
    @Bean
    public Binding directBinding(DirectExchange directExchange, Queue directQueue){
        /**
         * 参数1：需要绑定的队列
         * 参数2：需要绑定的交换机
         * 参数3：RoutingKey
         */
        return BindingBuilder.bind(directQueue).to(directExchange)
                .with("bootDirectRoutingKey");
    }

}
