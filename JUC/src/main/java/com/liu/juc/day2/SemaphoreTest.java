package com.liu.juc.day2;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * @author lms
 * @date 2021-09-04 - 11:16
 * 信号量
 * 模拟车位停车，假设停车场只有3个停车位，当前来了6辆车，
 * 使用？
 * ·1. semaphore.acquire();假设已经满了，等待，等待被释放
 *  2. semaphore.release();会将当前的信号量进行释放，然后唤醒其他等待的线程
 *  作用: 多个共享资源互斥的作用，并发限流，控制最大的线程数
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        // 模拟3个停车位
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                try {
                    // 有车进来了,信号量获取车牌号
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " 号车拿到了车位");
                    // 停车2秒
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName() + " 号车离开了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 离开停车场
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
