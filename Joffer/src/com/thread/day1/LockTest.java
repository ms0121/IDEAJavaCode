package com.thread.day1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lms
 * @date 2021-09-02 - 23:13
 * Lock锁的使用，显示的同步锁，需要进行显示的上锁和解锁
 */
public class LockTest {
    public static void main(String[] args) {
        LockThread lockThread = new LockThread();
        LockThread lockThread1 = new LockThread();
        lockThread.start();
        lockThread1.start();
        new LockThread().start();

    }
}


class LockThread extends Thread{
    private static int ticket = 10;

    // 创建Lock锁的对象,并保证只能有一个锁
    private final Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            try {
                // 上锁
                lock.lock();
                if (ticket > 0){
                    try {
                        System.out.println(ticket--);
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            } finally {
                // 解锁
                lock.unlock();
            }
        }
    }
}
