package com.liu.juc.day1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lms
 * @date 2021-09-03 - 15:44
 */
public class LockTest {

    public static void main(String[] args) {
        Ticket1 ticket1 = new Ticket1();
        new Thread(() -> {
            ticket1.sale();
        }, "A").start();
        new Thread(() -> {
            ticket1.sale();
        }, "B").start();
        new Thread(() -> {
            ticket1.sale();
        }, "C").start();
    }

}

class Ticket1 {

    private Integer ticketNum = 30;

    // 创建锁
    Lock lock = new ReentrantLock();

    // 卖票
    // 使用lock锁的方式实现
    public void sale() {
        // 上锁
        lock.lock();
        // 对于被同步的业务方法使用try进行包围设置
        try {
            while (ticketNum > 0) {
                System.out.println(Thread.currentThread().getName() + "出售第 " +
                        (ticketNum--) + "票，还剩下 " + ticketNum + "张票");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 解锁
            lock.unlock();
        }
    }
}
