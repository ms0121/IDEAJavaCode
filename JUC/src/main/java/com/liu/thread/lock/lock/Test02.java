package com.liu.thread.lock.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lms
 * @date 2021-10-17 - 20:32
 */
public class Test02 implements Runnable{
    // 静态变量是所有对象共享的变量
    private static Lock lock = new ReentrantLock();
    private static int num = 0;

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                lock.lock();
                num++;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Test02 runnable = new Test02();
        Thread thread = new Thread(runnable);
        Thread thread1 = new Thread(runnable);

        thread.start();
        thread1.start();

        thread.join();
        thread1.join();

        System.out.println("num = " + num);
    }


}
