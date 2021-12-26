package com.liu.thread.p1;

/**
 * @author lms
 * @date 2021-10-09 - 15:46
 * 每隔一秒种输出一个值
 */
public class ThreadColock {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        System.out.println("Done!");
    }
}
