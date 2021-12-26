package com.liu.thread.p1;

/**
 * @author lms
 * @date 2021-10-09 - 13:30
 * 方式1：继承Thread类
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ", i = " + i +
                    ", ThreadId = " + Thread.currentThread().getId());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
