package com.liu.juc.day2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @author lms
 * @date 2021-09-04 - 10:34
 * CountDownLatch原理:
 *     数量会进行减一的操作
 *
 */
//计算器
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        // 设置计算器的总数是6，必须要执行任务的时候，再使用
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "-> go out");
                // 1. 每出去一个学生，计数器都会进行减一的操作
                countDownLatch.countDown();
                }
            ).start();
        }
        // 2. 等待计数器归0之后再执行下面的内容，否则等待
        // 3.每次有线程调用countDown()进行数量减一，假设计数器变为0，
        // countDownLatch.await()就会被唤醒，从而继续执行下面的内容
        countDownLatch.await();

        System.out.println("Close door!");

    }
}
