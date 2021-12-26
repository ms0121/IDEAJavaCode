package com.liu.juc.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lms
 * @date 2021-09-05 - 13:36
 * Executors创建线程的3种方式
 */
public class SelfDefineThreadPoolTest2 {
    public static void main(String[] args) {
        // 创建线程池的三种方式
        ExecutorService executorService = Executors.newSingleThreadExecutor(); // 单个线程
        // 默认创建的线程池中有5个线程
        ExecutorService executorService1 = Executors.newFixedThreadPool(5);
        // 可伸缩的线程池，遇强则强，遇弱则弱，
        ExecutorService executorService2 = Executors.newCachedThreadPool();

        try {
            for (int i = 0; i < 20; i++) {
                //使用了线程池之后，就要使用线程池来创建线程,
                final int tmp = i;
                executorService2.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " --> " + tmp);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 线程执行完毕，一定要关闭线程池
            executorService2.shutdown();
        }
    }
}
