package com.liu.mq;

import com.rabbitmq.client.*;

import java.io.UnsupportedEncodingException;

/**
 * @author lms
 * @date 2021-05-26 - 22:11
 */
public class Received {

    public static void main(String[] args) {
        // 1.获取连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        // 设置连接工厂的初始条件
        connectionFactory.setHost("192.168.115.128");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
//      connectionFactory.setVirtualHost("/");    // 访问的根路径

        Connection connection = null;
        Channel channel = null;

        try {
            // 2. 获取具体的某个连接
            connection = connectionFactory.newConnection();
            // 3. 从connection中获取channel
            channel = connection.createChannel();
            /**
             * 声明一个队列：
             *  参数1：为队列取名字
             *  参数2：是否为持久化队列
             *  参数3：是否排外，如果排外，这个队列只允许表示一个消费者监听
             *  参数4：是否自动删除，如果为true，则表示当队列中没有消息，也没有消费者的时候就会自动的删除这个队列
             *  参数5：为队列的一些属性设置通常为null即可
             *
             *  注意：
             *      1.声明队列时，如果当前的队列名称存在，则放弃声明，如果队列不存在则会声明一个新的队列
             *      2.队列名可以取任意值，但是要与消息接收是完全一致
             *      3.这行对吗可有可无，但是一定要在发送消息前确认队列名已经mq中，否则就会出现问题
             */
            channel.queueDeclare("queue2", true, false, false, null);
            /**
             * 接收消息
             *  参数1：当前消费者需要监听的队列名，队列名必须要与发送时的队列名一致，否则收不到消息
             *  参数2：消息是否自动确认，true表示自动确认，接收完消息以后会自动的将消息从队列中移除
             *  参数3：消息接收者的标签，用于多个消费者同时监听一个队列时用于确认消费者，通常为空字符串即可
             *  参数4：消息接收的回调方法，这个方法中具体完成对消息的处理代码
             *  注意：使用了basicConsume方法以后，会启动一个线程在持续的监听队列，如果队列中有消息的加入，则会自动接收消息
             */
           channel.basicConsume("queue2",true,"", new DefaultConsumer(channel){
              // 消息的具体接收和处理方法
              public void handleDelivery(String consumeTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws UnsupportedEncodingException {
                  String message = new String(body, "utf-8");
                  System.out.println("消费者: " + message);
              }
           });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /**
             * 注意：接受者不能关闭通道和连接，如果一旦关闭可能会造成接收是产生异常
             * 或者无法接收到消息
             */
        }
    }
}
