package com.liu.rabbit_ttl.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * @author lms
 * @date 2021-09-16 - 10:39
 * 配置普通交换机、队列和死信交换机、队列
 */
@Configuration
public class TtlQueueConfig {

    // 普通交换机和普通队列
    public static final String X_EXCHANGE = "X";
    public static final String QUEUE_A = "QA";
    public static final String QUEUE_B = "QB";
    // 不指定过期时间
    public static final String QUEUE_C = "QC";


    // 死信交换机和死信队列
    public static final String Y_DEAD_LETTER_EXCHANGE = "Y";
    public static final String DEAD_LETTER_QUEUE = "QD";

    // 创建死信交换机（默认创建的bean就是方法名）
    // 给容器中添加组件。以方法名作为组件的id。返回类型就是组件类型。返回的值，就是组件在容器中的实例
    // 所以当前的这个方法创建的bean实例的名字就是xExchange，在bean上可以进行更改名字
    @Bean("xExchange")
    public DirectExchange xExchange(){
        return new DirectExchange(X_EXCHANGE);
    }

    // 创建死信交换机
    @Bean("yExchange")
    public DirectExchange yExchange(){
        return new DirectExchange(Y_DEAD_LETTER_EXCHANGE);
    }

    // 声明队列A，ttl为10秒，并绑定到对应的死信交换机上面
    // 创建普通队列
    @Bean("queueA")
    public Queue queueA(){
        HashMap<String, Object> arguments = new HashMap<>();
        // 指定当前队列A的死信队列为Y_DEAD_LETTER_EXCHANGE
        arguments.put("x-dead-letter-exchange", Y_DEAD_LETTER_EXCHANGE);
        // 声明当前队列的死信路由key
        arguments.put("x-dead-letter-routing-key", "YD");
        // 声明队列的ttl过期时间,10s
        arguments.put("x-message-ttl", 10000);
        // 使用QueueBuilder创建队列并指定队列是否持久化，设置队列的相关的属性值
        return QueueBuilder.durable(QUEUE_A).withArguments(arguments).build();
    }

    // X交换机和队列A进行绑定
    // 需要指明使用的队列和交换机具体是哪个
    @Bean
    public Binding queueaBinding(@Qualifier("queueA") Queue queueA,
                                 @Qualifier("xExchange") DirectExchange xExchange){
        // 指明当前的交换机和队列绑定的路由key
        return BindingBuilder.bind(queueA).to(xExchange).with("XA");
    }


    // 创建普通队列B
    @Bean("queueB")
    public Queue queueB(){
        HashMap<String, Object> arguments = new HashMap<>();
        // 指定当前队列B的死信队列为Y_DEAD_LETTER_EXCHANGE
        arguments.put("x-dead-letter-exchange", Y_DEAD_LETTER_EXCHANGE);
        // 声明当前队列的死信路由key
        arguments.put("x-dead-letter-routing-key", "YD");
        // 声明队列的ttl过期时间,40s
        arguments.put("x-message-ttl", 40000);
        // 使用QueueBuilder创建队列并指定队列是否持久化，设置队列的相关的属性值
        return QueueBuilder.durable(QUEUE_B).withArguments(arguments).build();
    }

    // X交换机和队列A进行绑定
    // 需要指明使用的队列和交换机具体是哪个
    @Bean
    public Binding queuebBinding(@Qualifier("queueB") Queue queueB,
                                 @Qualifier("xExchange") DirectExchange xExchange){
        // 指明当前的交换机和队列绑定的路由key
        return BindingBuilder.bind(queueB).to(xExchange).with("XB");
    }

    // 创建死信队列
    @Bean("queueD")
    public Queue queueD(){
        return new Queue(DEAD_LETTER_QUEUE);
    }

    // 死信交换机和死信队列进行绑定
    @Bean
    public Binding queuedBinding(@Qualifier("queueD") Queue queueD,
                                 @Qualifier("yExchange") DirectExchange yExchange){
        // 指明当前的交换机和队列绑定的路由key
        return BindingBuilder.bind(queueD).to(yExchange).with("YD");
    }


    // 创建普通队列C，不指定过期时间
    @Bean("queueC")
    public Queue queueC(){
        HashMap<String, Object> arguments = new HashMap<>();
        // 指定当前队列C的死信队列为Y_DEAD_LETTER_EXCHANGE
        arguments.put("x-dead-letter-exchange", Y_DEAD_LETTER_EXCHANGE);
        // 声明当前队列的死信路由key
        arguments.put("x-dead-letter-routing-key", "YD");
        // 使用QueueBuilder创建队列并指定队列是否持久化，设置队列的相关的属性值
        return QueueBuilder.durable(QUEUE_C).withArguments(arguments).build();
    }

    // X交换机和队列C进行绑定
    // 需要指明使用的队列和交换机具体是哪个
    @Bean
    public Binding queuecBinding(@Qualifier("queueC") Queue queueC,
                                 @Qualifier("xExchange") DirectExchange xExchange){
        // 指明当前的交换机和队列绑定的路由key
        return BindingBuilder.bind(queueC).to(xExchange).with("XC");
    }
}

