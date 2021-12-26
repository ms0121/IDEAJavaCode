package com.liu.thread.lock.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lms
 * @date 2021-10-17 - 20:17
 */
public class Test01 {

    private static Lock lock = new ReentrantLock();

    public static void m(){
        lock.lock();
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + ", " + i);
        }
        lock.unlock();
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                m();
            }
        };

        Thread thread = new Thread(runnable);
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread.start();
        thread1.start();
        thread2.start();
    }
}
