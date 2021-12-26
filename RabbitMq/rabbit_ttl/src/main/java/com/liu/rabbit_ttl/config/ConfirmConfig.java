package com.liu.rabbit_ttl.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lms
 * @date 2021-09-17 - 15:26
 */
@Configuration
public class ConfirmConfig {

    // 交换机的名称
    public static final String CONFIRM_EXCHANGE = "confirm_exchange";
    // 队列名称
    public static final String CONFIRM_QUEUE = "confirm_queue";
    // 路由key
    public static final String CONFIRM_KEY = "confirm_key";

    // 备份交换机
    public static final String BACKUP_EXCHANGE = "backup_exchange";
    // 备份队列
    public static final String BACKUP_QUEUE = "backup_queue";
    // 报警队列
    public static final String WARNING_QUEUE = "warning_queue";

    // 绑定普通交换机和备份交换机
    @Bean("confirmExchange")
    public DirectExchange confirmExchange(){
        return ExchangeBuilder.directExchange(CONFIRM_EXCHANGE).durable(true)
                .withArgument("alternate-exchange",BACKUP_EXCHANGE).build();
    }

    // 备份交换机的名称
    @Bean("backup_exchange")
    public FanoutExchange backup_exchange() {
        return new FanoutExchange(BACKUP_EXCHANGE);
    }

    // 备份队列的名称
    @Bean("backup_queue")
    public Queue backup_queue() {
        return QueueBuilder.durable(BACKUP_QUEUE).build();
    }

    // 备份报警队列的名称
    @Bean("warning_queue")
    public Queue warning_queue() {
        return QueueBuilder.durable(WARNING_QUEUE).build();
    }

    // 进行备份交换机和备份队列之间的绑定
    @Bean
    public Binding queueBackupBinding(@Qualifier("backup_exchange") FanoutExchange fanoutExchange,
                                      @Qualifier("backup_queue") Queue queue) {
        // fanout类型的交换机和队列之间没有路由key
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

    // 进行备份交换机和备份报警队列之间的绑定
    @Bean
    public Binding queueWarningBinding(@Qualifier("backup_exchange") FanoutExchange fanoutExchange,
                                       @Qualifier("warning_queue") Queue queue) {
        // fanout类型的交换机和队列之间没有路由key
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

    // 交换机的名称
    @Bean("confirm_exchange")
    public DirectExchange confirm_exchange() {
        return new DirectExchange(CONFIRM_EXCHANGE);
    }

    // 队列的名称
    @Bean("confirm_queue")
    public Queue confirm_queue() {
        return QueueBuilder.durable(CONFIRM_QUEUE).build();
    }

    // 指定使用上面创建的交换机和队列进行互相绑定
    @Bean
    public Binding queueBinding(@Qualifier("confirm_exchange") DirectExchange directExchange,
                                @Qualifier("confirm_queue") Queue queue) {
        return BindingBuilder.bind(queue).to(directExchange).with(CONFIRM_KEY);
    }
}
