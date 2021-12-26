package com.liu.thread.producer;

/**
 * @author lms
 * @date 2021-10-12 - 21:24
 * 使用线程模拟消费者
 */
public class ConsumerThread extends Thread {

    // 消费者调用proValue对象中的getValue方法消费信息
    private ProValue proValue;

    public ConsumerThread(ProValue proValue) {
        this.proValue = proValue;
    }

    @Override
    public void run() {
        // 模拟消费
        while (true){
            proValue.getValue();
        }
    }
}
