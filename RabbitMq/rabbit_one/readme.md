/**
* 消费者消费消息:
* 参数1：消费哪个队列
* 参数2：消费成功之后是否要自动应答，true代表自动应答，false手动应答
* 参数3：消费者成功消费的回调
* 参数4：消费者取消消费的回调
*/
channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);


/**
* 生成一个队列：
*  参数1：队列名称
*  参数2：队列里面的消息是否持久化，默认消息存储在内存中
*  参数3：该队列是否只供一个消费者进行消费，是否共享，true表示可以多个消费者共享
*  参数4：是否自动删除，最后一个消费者消费断开连接以后，该队列是否自动删除，true 自动删除
*  参数5：其他参数
*/
channel.queueDeclare(QUEUE_NAME, false, false, false, null);


/**
* 发送一个消息
* 参数1、消息发送到哪个交换机
* 参数2. bingdingkey
* 参数3. 其他的参数信息
* 参数4. 发送消息的消息体
*/
channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
