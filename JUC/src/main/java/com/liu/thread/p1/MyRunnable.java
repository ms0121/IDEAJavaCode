package com.liu.thread.p1;

/**
 * @author lms
 * @date 2021-10-09 - 15:28
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println(Thread.currentThread() + ", i = " + i);
        }
    }
}
