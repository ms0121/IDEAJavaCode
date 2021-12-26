package com.liu.thread.threadGroup;

/**
 * @author lms
 * @date 2021-10-18 - 19:37
 * 设置某个线程组为守护线程，守护线程：
 */
public class Test03 {
    public static void main(String[] args) throws InterruptedException {
        // 创建线程组
        ThreadGroup group = new ThreadGroup("group");
        // 设置线程组为守护线程
        group.setDaemon(true);

        // 创建3个线程,并添加到线程组中
        for (int i = 0; i < 3; i++) {
            new Thread(group,new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        System.out.println(Thread.currentThread().getName() + ", ====> " + j);
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }

        // 让main线程休眠3秒
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName() + ",  end=========");
    }
}
