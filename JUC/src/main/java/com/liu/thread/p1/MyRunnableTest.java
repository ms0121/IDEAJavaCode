package com.liu.thread.p1;

/**
 * @author lms
 * @date 2021-10-09 - 15:29
 * 创建线程的第二种方式：实现runnable接口
 *
 * Thread.currentThread():获取当前线程（执行当前方法的线程）的名称
 */
public class MyRunnableTest {
    public static void main(String[] args) {
        // 实现类
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();

        for (int i = 0; i < 30; i++) {
            System.out.println(Thread.currentThread() + ", i = " + i);
        }

        // 匿名内部类的方式
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    System.out.println(Thread.currentThread() + ", i = " + i);
                }
            }
        });
        thread1.start();
    }
}
