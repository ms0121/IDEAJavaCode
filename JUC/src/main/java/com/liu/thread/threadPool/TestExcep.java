package com.liu.thread.threadPool;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lms
 * @date 2021-10-19 - 13:00
 * 测试线程池的异常信息处理机制
 */
public class TestExcep {

    static class Service implements Runnable{

        private int x;
        private int y;

        public Service(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ", 计算结果为: " + x + " / " + y + " = " + (x / y));
        }
    }

    public static void main(String[] args) {

        // 创建线程池
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(0, Integer.MAX_VALUE, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2));

        /**
         * 从线程执行的结果可以看到，当i=0的时候，会出现除0异常，但是程序并没有抛出错误的信息，
         * 可以看得出，线程池中出现的异常信息会被线程池吃掉，解决方法：
         *  1.将submit方法改为execute()方法
         *  2.对线程池进行拓展，重新包装sumbit方法
         */
        for (int i = 0; i < 5; i++) {
            threadPoolExecutor.submit(new Service(10, i));
        }
    }



}
