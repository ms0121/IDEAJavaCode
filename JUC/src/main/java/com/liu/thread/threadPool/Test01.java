package com.liu.thread.threadPool;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author lms
 * @date 2021-10-18 - 20:22
 * 线程池的基本使用
 */
public class Test01 {
    public static void main(String[] args) {
        // 创建有5个线程的线程池
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);

        // 向线程池中添加18个任务，任务会存放在阻塞队列里面，线程池中的5个线程会从阻塞队列中拿去任务去执行
        for (int i = 0; i < 20; i++) {
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread() + ", " + Thread.currentThread().getId());
                    // 模拟任务执行消耗的时长
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        // 关闭线程池
        fixedThreadPool.shutdown();
    }
}
