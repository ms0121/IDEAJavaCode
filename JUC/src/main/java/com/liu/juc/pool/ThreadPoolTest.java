package com.liu.juc.pool;

import java.util.concurrent.*;

/**
 * @author lms
 * @date 2021-09-05 - 13:36
 * Executors创建线程的3种方式
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
//        // 创建线程池的三种方式
//        ExecutorService executorService = Executors.newSingleThreadExecutor(); // 单个线程
//        // 默认创建的线程池中有5个线程
//        ExecutorService executorService1 = Executors.newFixedThreadPool(5);
//        // 可伸缩的线程池，遇强则强，遇弱则弱，
//        ExecutorService executorService2 = Executors.newCachedThreadPool();


//四种策略使用方式：
//  1. new ThreadPoolExecutor.AbortPolicy()  // 当前银行办理业务的人满了，还有人进来，就不处理这个人的业务信息了，抛出异常
//  2. new ThreadPoolExecutor.CallerRunsPolicy()  // 如果处理的线程超过了阈值，就会交给main线程进行执行
//  3. new ThreadPoolExecutor.DiscardPolicy()  // 队列满了，会丢掉任务，但是不会抛出异常信息
//  4. new ThreadPoolExecutor.DiscardOldestPolicy() // 队列满了，会和最早拿到线程的竞争，竞争失败就会丢掉任务


//  最大线程池应该如何定义：
//      1.cpu 密集型 几核 就是几，可以保持cpu的效率最高
//      2.io 密集型  > 判断你的线程中十分消耗IO的线程
//        程序， 15个大型的任务，IO十分占用资源

//      获取本机是几核的方法
        System.out.println("Runtime.getRuntime().availableProcessors() = " +
                Runtime.getRuntime().availableProcessors());


////      自定义线程池(只推荐使用这种)，使用工具类不安全
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
//                2,
//                5,
//                2,
//                TimeUnit.SECONDS,
//                new ArrayBlockingQueue<>(3), // 超过阻塞队列的最大数就会触发maxNumPoolSize
//                Executors.defaultThreadFactory(),  // 线程工厂，使用的是默认的值
////                new ThreadPoolExecutor.AbortPolicy()
//                // 当前银行办理业务的人满了，还有人进来，就不处理这个人的业务信息了，抛出异常
////                new ThreadPoolExecutor.CallerRunsPolicy()  // 如果处理的线程超过了阈值，就会交给main线程进行执行
////                new ThreadPoolExecutor.DiscardPolicy()  // 队列满了，会丢掉任务，但是不会抛出异常信息
//                new ThreadPoolExecutor.DiscardOldestPolicy() // 队列满了，会和最早拿到线程的竞争，竞争失败就会丢掉任务
//        );
//
//
//        try {
//            // 最大处理数为  maxNumPoolSize + 阻塞队列的大小
//            for (int i = 1; i <= 15; i++) {
//                //使用了线程池之后，就要使用线程池来创建线程,
//                final int tmp = i;
//                threadPoolExecutor.execute(() -> {
//                    System.out.println(Thread.currentThread().getName() + " --> " + tmp);
//                });
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            // 线程执行完毕，一定要关闭线程池
//            threadPoolExecutor.shutdown();
//        }
    }
}
