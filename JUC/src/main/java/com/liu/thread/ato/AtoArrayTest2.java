package com.liu.thread.ato;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author lms
 * @date 2021-10-10 - 8:54
 * 给每个元素都自增1，循环1000次
 */
public class AtoArrayTest2 {
    // 创建一个原子数组
    private static AtomicIntegerArray array = new AtomicIntegerArray(10);

    public static void main(String[] args) {
        Thread[] threads = new Thread[array.length()];

        for (int i = 0; i < array.length(); i++) {
            threads[i] = new atoArray();
        }
        // 开启子线程
        for (Thread thread : threads) {
            thread.start();
        }

        // 要想在主线程中查看到所有线程执行完成得到的结果，需要将子线程进行合并
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(array);

    }

    static class atoArray extends Thread{

        // 让每个数组中的元素值都进行自增1000次
        @Override
        public void run() {
            for (int j = 0; j < 1000; j++) {
                for (int i = 0; i < array.length(); i++) {
                    array.incrementAndGet(i);
                }
            }
        }
    }
}
