package com.thread.day1;

/**
 * @author lms
 * @date 2021-08-27 - 12:07
 * 创建线程的方式1：继承Thread类，重写run方法，调用上start方法开启线程
 * 总结：注意线程开启后不一定立即执行，由CPU调度执行
 */
public class Demo1 extends Thread{
    // 重写run方法
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("我在run()方法中 + " + i);
        }
    }

    public static void main(String[] args) {

        // main线程，主线程
        Demo1 thread = new Demo1();
        thread.start();

        for (int i = 0; i < 30; i++) {
            System.out.println("我在学习主线程 + " + i);
        }
    }
}
