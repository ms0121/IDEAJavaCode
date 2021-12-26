package com.liu.bootmq.service.impl;

import com.liu.bootmq.service.ReceivedService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lms
 * @date 2021-05-27 - 20:52
 */
@Service
public class ReceivedServiceImpl implements ReceivedService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void receivedMessage() {
//        // 绑定消费者要监听的队列
//        String message = (String) amqpTemplate.receiveAndConvert("bootDirectQueue");
//        System.out.println("message = " + message);
    }


    /**
     *  @RabbitListener：注解用于标记当前的方法是一个Rabbitmq的消息监听方法，作用是持续性的自动接收消息
     *  这个方法不需要手动的调用spring，spring会自动的调用该方法
     *   属性：queue：用于指定要监听的队列名，用于队列的监听，可以监听多个
     * @param message 接收到的具体的消息数据
     *
     *  注意：如果当前监听方法正常结束，spring就会自动确认消息，如果出现异常则不会确认消息
     *       因此在消息处理时，我们需要做好消息的防止重复处理工作
     */
    @RabbitListener(queues = {"bootDirectQueue"})
    public void directReceived(String message){
        System.out.println("接收到的监听信息是 message = " + message);
    }



    @RabbitListener(
            bindings = {@QueueBinding  // @QueueBinding注解要完成队列和交换机
            (value = @Queue(),// @Queue创建一个队列，没有指定参数则表示创建一个随机队列
            exchange = @Exchange(name = "fanoutExchange", type = "fanout"))})  // 创建交换机
    public void fanoutReceived01(String message){
        System.out.println("fanou01 - message = " + message);
    }

    @RabbitListener(
            bindings = {@QueueBinding  // @QueueBinding注解要完成队列和交换机
                    (value = @Queue(),// @Queue创建一个队列，没有指定参数则表示创建一个随机队列
                            exchange = @Exchange(name = "fanoutExchange", type = "fanout"))})  // 创建交换机
    public void fanoutReceived02(String message){
        System.out.println("fanout02 - message = " + message);
    }


}
