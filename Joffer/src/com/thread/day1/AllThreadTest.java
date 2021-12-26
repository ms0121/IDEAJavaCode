package com.thread.day1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author lms
 * @date 2021-09-03 - 14:05
 */
public class AllThreadTest {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();

        MyThread2 myThread2 = new MyThread2();
        new Thread(myThread2).start();

        FutureTask<Integer> task = new FutureTask<>(new MyThread3());
        new Thread(task).start();
        try {
            Integer integer = task.get();
            System.out.println("integer = " + integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

//继承Thread类
class MyThread1 extends Thread{
    @Override
    public void run() {
        System.out.println("MyThread1");
    }
}

//实现runnable接口
class MyThread2 implements Runnable{
    @Override
    public void run() {
        System.out.println("MyThread2");
    }
}

// 实现Callable接口
class MyThread3 implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        return 100;
    }
}




