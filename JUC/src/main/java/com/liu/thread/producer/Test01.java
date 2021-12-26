package com.liu.thread.producer;

/**
 * @author lms
 * @date 2021-10-12 - 21:28
 */
public class Test01 {
    public static void main(String[] args) {

        ProValue proValue = new ProValue();
        // 生产者和消费者
        ProThread proThread = new ProThread(proValue);
        ConsumerThread consumerThread = new ConsumerThread(proValue);

        proThread.start();
        consumerThread.start();
    }
}
