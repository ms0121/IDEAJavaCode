package com.liu.juc.eightLock;

import java.util.concurrent.TimeUnit;

/**
 * @author lms
 * @date 2021-09-03 - 19:48
 * 关于锁的8个问题？
 *
 * 1.在标准的情况下，两个线程先 发短信 还是 打电话？  1.发短信，2.打电话
 * 2.send 延迟4秒，两个线程先发短信还是打电话？  1.发短信，2.打电话
 */
public class Test1 {
    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(()->{
            phone.send();
        }, "A").start();

        // 使用juc的睡眠功能
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone.call();
        }, "B").start();


    }
}

class Phone{

    /**
     * synchronized 锁的对象是方法的调用者
     * 两个方法用的都是同一个锁，谁先拿到谁就先执行
     */
    public synchronized void send(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public synchronized void call(){
        System.out.println("打电话");
    }
}
