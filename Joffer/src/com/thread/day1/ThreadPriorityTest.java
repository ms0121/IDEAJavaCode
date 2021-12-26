package com.thread.day1;

/**
 * @author lms
 * @date 2021-09-02 - 21:23
 * 测试线程的优先级：线程的优先级在 1-10之间，默认使用1,5,10
 * 线程调度器按照优先级决定应该调度哪个线程来执行。
 * 注意：线程的优先级低只是意味着获得调度的概率低，并不是优先级低就不会
 * 被调用，这都是要看cpu的调度。
 */
public class ThreadPriorityTest {

    public static void main(String[] args) {
        // 主线程的优先级测试
        System.out.println(Thread.currentThread().getName() + " ---> " + Thread.currentThread().getPriority());

        MyPriority myPriority = new MyPriority();

        Thread thread1 = new Thread(myPriority);
        Thread thread2 = new Thread(myPriority);
        Thread thread3 = new Thread(myPriority);
        Thread thread4 = new Thread(myPriority);

        thread1.start();

        //
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread2.start();

        // 设置优先级最高权限  10
        thread3.setPriority(Thread.MAX_PRIORITY);
        thread3.start();

        thread4.setPriority(1);
        thread4.start();
    }
}

class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " ---> " + Thread.currentThread().getPriority());
    }
}
