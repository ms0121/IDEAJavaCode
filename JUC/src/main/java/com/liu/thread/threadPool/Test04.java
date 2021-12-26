package com.liu.thread.threadPool;

import java.util.concurrent.*;

/**
 * @author lms
 * @date 2021-10-19 - 8:28
 * 创建线程池的使用
 */
public class Test04 {
    public static void main(String[] args) {

        // 使用默认的线程工厂，并自定义拒绝策略
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println(r + " 被丢弃..........");
            }
        });

        // 创建任务
        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName() + ", " + Thread.currentThread().getId());
        };

        // 往线程池里面添加30个任务
        for (int i = 0; i < 30; i++) {
            threadPoolExecutor.submit(r);
        }

        // 关闭线程池
        threadPoolExecutor.shutdown();
    }
}
