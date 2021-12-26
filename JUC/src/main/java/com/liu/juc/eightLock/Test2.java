package com.liu.juc.eightLock;

import java.util.concurrent.TimeUnit;

/**
 * @author lms
 * @date 2021-09-03 - 20:02
 *
 * 3.有普通方法的先执行，因为没有同步锁的限制。
 * 4.
 */
public class Test2 {
    public static void main(String[] args) {
        Phone2 phone2 = new Phone2();
        Phone2 phone3 = new Phone2();

        new Thread(() -> {
            phone2.send();
        }, "A").start();

        // 使用juc的睡眠功能，正常情况下使用的都是juc里面的线程睡眠的方法，不会去使用Thread.sleep()
        // 因为这个方法不怎么使用
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            phone3.call();
        }, "B").start();
    }
}

class Phone2 {

    /**
     * synchronized 锁的对象是方法的调用者
     * 两个方法用的都是同一个锁，谁先拿到谁就先执行
     */
    public synchronized void send() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public synchronized void call() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("打电话");
    }

    public void hello(){
        System.out.println("你好");
    }

}
