package com.liu.juc.day1;

/**
 * @author lms
 * @date 2021-09-03 - 15:23
 * Synchronized同步锁的实现：本质是队列和锁
 */

public class SynchronizedTest {
    public static void main(String[] args) {
        // 多个线程操作同一个资源
        Ticket ticket = new Ticket();

        new Thread(() -> {
                ticket.sale();
        }, "A").start();

        new Thread(() -> {
                ticket.sale();
        }, "B").start();

        new Thread(() -> {
                ticket.sale();
        }, "C").start();
    }
}

//创建一个共享资源类
class Ticket {

    //
    private Integer ticketNum = 10;

    // 卖票
    // 1.（线程不安全的方法）,不使用synchronized
    // 2.线程安全的解决办法，添加一个synchronized，让同步方法变得同步安全起来
    public synchronized void sale() {
        while (ticketNum > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "出售第 " +
                    (ticketNum--) + "票，还剩下 " + ticketNum + "张票");
        }
    }
}

