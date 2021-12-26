package com.liu.learn;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lms
 * @date 2021-10-11 - 12:10
 * public ThreadPoolExecutor(int corePoolSize,  // 线程池的核心线程数
 *                               int maximumPoolSize, // 线程池的最大线程数
 *                               long keepAliveTime, // 非核心线程的空闲时间
 *                               TimeUnit unit, // 时间单位
 *                               BlockingQueue<Runnable> workQueue, // 工作队列
 *                               ThreadFactory threadFactory, // 线程工厂
 *                               RejectedExecutionHandler handler) // 拒绝策略
 */
public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor threadPoolExecutor = null;
        try {
            threadPoolExecutor =
                    new ThreadPoolExecutor(2, 3, 2, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2));

            // 一个run方法就是一个任务
            Runnable r = () -> {
                System.out.println(Thread.currentThread().getName());
            };

            // 将任务交给线程池(超过 3（最大线程数） + 2（队列）)
            for (int i = 0; i < 6; i++) {
                threadPoolExecutor.execute(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭线程池
            if (threadPoolExecutor != null){
                threadPoolExecutor.shutdown();
                // 等待一分钟，如果线程池无法关闭，则至今关闭线程池
                if (!threadPoolExecutor.awaitTermination(1, TimeUnit.MINUTES)){
                    threadPoolExecutor.shutdownNow();
                }
            }
        }
    }
}
