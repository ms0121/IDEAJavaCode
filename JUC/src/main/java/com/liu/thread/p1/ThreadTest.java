package com.liu.thread.p1;

/**
 * @author lms
 * @date 2021-10-09 - 13:28
 * 创建线程的方式：
 *  方式1：继承Thread类进行创建线程
 *
 */
public class ThreadTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        // 启动线程
        myThread.start();

        // 主线程
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread() + ", i = " + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
