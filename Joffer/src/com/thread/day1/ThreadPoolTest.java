package com.thread.day1;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lms
 * @date 2021-09-03 - 13:52
 * 线程池
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        // 创建线程池，以及设置线程池的大小为10
        // Executors线程池的工具类，用于创建并返回不同类型的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        // 执行操作
        service.execute(new Car());
        service.execute(new Car());
        service.execute(new Car());
        service.execute(new Car());

        // 关闭线程池
        service.shutdown();
    }
}

class Car implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

