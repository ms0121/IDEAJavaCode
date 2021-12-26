package com.liu.juc.day2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author lms
 * @date 2021-09-04 - 9:57
 * Callable和synchronized的区别？
 *  1.Callable可以有返回值，可以抛出异常，但是synchronized不可以
 *  2.方法不同，call()和run()方法
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 启动
        MyThread myThread = new MyThread();
        // 适配器
        FutureTask futureTask = new FutureTask<>(myThread);
        // 启动线程
        new Thread(futureTask, "A").start();

        Integer o = (Integer) futureTask.get();
        System.out.println("o = " + o);
    }
}

class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + ", call()被调用了.......");
        return 1024;
    }
}
