package com.liu.thread.producer;

/**
 * @author lms
 * @date 2021-10-12 - 21:20
 * 定义线程类模拟生产者
 */
public class ProThread extends Thread{

    // 生产者调用proValue对象中的setValue方法生产信息
    private ProValue proValue;

    public ProThread(ProValue proValue) {
        this.proValue = proValue;
    }

    @Override
    public void run() {
        while (true){
            proValue.setValue();
        }
    }
}
