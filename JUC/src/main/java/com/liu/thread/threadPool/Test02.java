package com.liu.thread.threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author lms
 * @date 2021-10-18 - 20:36
 *
 * 创建一个有调度功能的线程池: ScheduledExecutorService
 */
public class Test02 {

    public static void main(String[] args) {
        // 具有调度功能的线程池
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);

        // 延迟2秒后再执行任务
        executorService.schedule(() -> {
            System.out.println("正在执行任务..........");
            System.out.println("任务执行完成..........");
        }, 2, TimeUnit.SECONDS);

        // 按照固定的频率执行任务，开启任务的时候是固定的，
//        executorService.scheduleAtFixedRate(() -> {
//            System.out.println(Thread.currentThread().getId() + ", start........");
//
//            // 假设任务执行耗费的时间是3秒钟（因为任务执行的时候大于每个任务间隔执行的时间，所以在任务执行完毕之后
//            // 不需要再次等待2秒钟，而是直接又执行任务）
//
//            // 3秒钟后开始执行任务,然后每隔2秒钟执行一次
//        }, 3,2, TimeUnit.SECONDS);


        // 按照固定的频率执行任务，开启任务的时候是固定的，(无论任务执行多久，只要任务结束后，都要等待指定的时间
        // 后才会去执行下一个任务)
        executorService.scheduleWithFixedDelay(() -> {
            System.out.println(Thread.currentThread().getId() + ", start........" + System.currentTimeMillis());

            // 3秒钟后开始执行任务,然后每隔2秒钟执行一次
        }, 3,2, TimeUnit.SECONDS);



        // 关闭线程池
//        executorService.shutdown();
    }

}
