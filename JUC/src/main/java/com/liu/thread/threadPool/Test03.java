package com.liu.thread.threadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lms
 * @date 2021-10-19 - 7:52
 */
public class Test03 {
    public static void main(String[] args) {

        // 使用默认的线程工厂和默认的拒绝策略
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(3, 5, 2, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2));

        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("============");
            }
        });

        System.out.println(threadPoolExecutor.getActiveCount());
    }
}
