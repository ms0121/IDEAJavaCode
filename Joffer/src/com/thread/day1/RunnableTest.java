package com.thread.day1;

/**
 * @author lms
 * @date 2021-08-27 - 12:20
 */
public class RunnableTest implements Runnable {
    // 重写run方法
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("我在run()方法中 + " + i);
        }
    }

    public static void main(String[] args) {

        // main线程，主线程
        RunnableTest runnableTest = new RunnableTest();
        Thread thread = new Thread(runnableTest);
        thread.start();

        for (int i = 0; i < 30; i++) {
            System.out.println("我在学习主线程 + " + i);
        }
    }
}
