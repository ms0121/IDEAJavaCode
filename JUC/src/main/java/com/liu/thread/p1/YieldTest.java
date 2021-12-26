package com.liu.thread.p1;

/**
 * @author lms
 * @date 2021-10-09 - 15:52
 */
public class YieldTest {
    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    if (i == 12) {
                        // 让当前线程放弃CPU的资源，但是不能保证其他线程一定能够获取到cpu，所以就有可能当前线程停止
                        // 后又重新被启动
                        Thread.yield();
                    }
                    System.out.println(Thread.currentThread().getName() + " , i=" + i);
                }
            }
        });
        // 设置线程的优先级( 1 - 10 超出这个范围会抛出错误，优先级越高，获得的cpu资源越多，不保证优先级高的线程
        // 先执行)
        thread.setPriority(5);
        thread.start();

        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + " , i=" + i +
                    " ,id=" + Thread.currentThread().getId());
        }

    }
}
