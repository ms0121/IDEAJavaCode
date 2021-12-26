package com.liu.juc.day1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lms
 * @date 2021-09-03 - 17:01
 * Lock
 * Condition  await() signalAll()
 * 但是从当前的执行代码中可以看出，线程执行的顺序并不是我们想象中的a-d，而是两个两个的执行输出的操作
 * 但是，Condition可以设置执行的次序
 */
public class LockProConTest {
    public static void main(String[] args) {
        Data1 data = new Data1();
        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                data.increment();
            }
        }, "A").start();

        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                data.decrease();
            }
        }, "B").start();

        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                data.increment();
            }
        }, "C").start();

        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                data.decrease();
            }
        }, "D").start();
    }
}

//Lock实现的生产者和消费者
class Data1 {
    private int num = 0;

    // 使用锁
    Lock lock = new ReentrantLock();
    // 执行等待和唤醒线程的操作
    Condition condition = lock.newCondition();

    // 生产商品
    public void increment() {
        // 上锁
        lock.lock();
        try {
            while (num != 0) {
                // 生产者等待，消费者进行消费
                condition.await();
            }
            // 生产者执行业务方法
            num++;
            System.out.println(Thread.currentThread().getName() + " --> " + num);
            // 通知(唤醒)消费者
            condition.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 解锁
            lock.unlock();
        }
    }

    // 消费
    public void decrease() {
        // 上锁
        lock.lock();
        try {
            while (num == 0) {
                // 消费者等待，让生产者进行生产
                condition.await();
            }
            // 执行生产业务
            num--;
            System.out.println(Thread.currentThread().getName() + " --> " + num);
            // 唤醒
            condition.signalAll();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放锁
            lock.unlock();
        }
    }
}

