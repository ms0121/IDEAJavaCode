package com.liu.juc.volatile1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lms
 * @date 2021-09-06 - 13:46
 * 原子性： 不可分割
 *  线程A在执行任务的时候，不能被打扰，也不能被分割，要么同时成功，要么同时失败
 *
 * 如何验证volatile不是原子性的？ 使用多个线程对同一个volatile修饰的变量进行调用加法运算
 * 如果是原子性的，那么20个线程，每个线程执行1000次，最终的结果应该是20000
 */
public class VolatileTest1 {

    // 从最终的结果可以得知，volatile是不保证原子性的
//    private volatile static int num = 0;


    // 使用原子性变量保证原子性操作
    private static volatile AtomicInteger num = new AtomicInteger();


    /**
     * 解决办法：
     *  1.使用synchronized或者lock锁的方式保证原子性操作
     *  2.使用原子性的变量也可以保证原子操作（不使用synchronized或者Lock的情况下）
     */

    public static void add(){
        // 自增的运算
        num.getAndIncrement();
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }

        // 还存在main，gc线程
        while (Thread.activeCount() > 2){
            Thread.yield();
        }

        System.out.println("num = " + num);
    }
}
