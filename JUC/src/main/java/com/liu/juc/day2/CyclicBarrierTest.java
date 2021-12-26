package com.liu.juc.day2;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @author lms
 * @date 2021-09-04 - 10:46
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {

        // 可以理解为加法计算器
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, ()->{
            System.out.println("Full, close door！");
        });

        for (int i = 1; i <= 7; i++) {
            // 因为lambda表达式就是新建了一个类，所以无法直接将i变量传入到一个类中
            final int temp = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + " " + temp);
                // 计算,当达到7个线程的时候调用CyclicBarrier中的线程，
                // 如果无法达到7个线程就会一直等待
                // 多出的线程就会在下一次的执行当中出现阻塞的现象，因此在设置的时候要非常的注意
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }
}
