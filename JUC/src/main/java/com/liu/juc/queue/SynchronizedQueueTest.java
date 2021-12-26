package com.liu.juc.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author lms
 * @date 2021-09-04 - 16:05
 * synchronizedQueue同步队列
 */
public class SynchronizedQueueTest {
    public static void main(String[] args) {
        // 同步队列，特点，进去一个元素，必须等待取出来之后，才能
        // 往里面添加一个元素
        BlockingQueue<Integer> blockingQueue = new SynchronousQueue<>();

        // 模拟同步队列的一进一出
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName() + " put " + "1");
                blockingQueue.put(1);
                System.out.println(Thread.currentThread().getName() + " put " + "2");
                blockingQueue.put(2);
                System.out.println(Thread.currentThread().getName() + " put " + "3");
                blockingQueue.put(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
        }}, "T1").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + " => " + blockingQueue.take());
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + " => " + blockingQueue.take());
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + " => " + blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
        }}, "T2").start();

    }
}
