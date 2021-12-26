package com.liu.thread.p3;

/**
 * @author lms
 * @date 2021-10-10 - 22:58
 */
public class WaitTest02 {
    public static final String lock = "abc";
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println("线程1开始执行了........");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程1执行结束了。。。。。。。。。");
                }
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println("线程2开始执行了........");
                    lock.notify();
                    System.out.println("线程2执行结束了。。。。。。。。。");
                }
            }
        });

        thread.start();
        Thread.sleep(100);
        thread1.start();
    }
}
