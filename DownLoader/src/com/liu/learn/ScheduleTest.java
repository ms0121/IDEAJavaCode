package com.liu.learn;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author lms
 * @date 2021-10-11 - 9:21
 */
public class ScheduleTest {
    public static void main(String[] args) {

    }

    public void test2(){
        // 表示在线程池中创建几个线程
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(1);
        // 设置延迟2秒后进行执行任务,然后每隔2秒进行打印一次（执行）
        threadPool.scheduleAtFixedRate(()->{
            System.out.println(System.currentTimeMillis());
            // 模拟延时操作（额外延时的2秒钟会被计算到睡眠时间当中）
            try {
                // 线程开始执行后睡眠5秒钟
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 2, 2,TimeUnit.SECONDS);
    }

    public void test1(){
        // 表示在线程池中创建几个线程
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(1);
        // 设置延迟2秒后进行执行任务
        threadPool.schedule(()->{
            System.out.println(Thread.currentThread().getName() + " 执行了方法...");
        }, 2, TimeUnit.SECONDS);

        // 关闭线程池
        threadPool.shutdown();
    }
}
