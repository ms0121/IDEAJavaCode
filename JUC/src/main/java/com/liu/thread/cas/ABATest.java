package com.liu.thread.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author lms
 * @date 2021-10-10 - 9:28
 * AtomicReference原子类会出现ABA问题，因此可以使用AtomicStampedReference解决ABA问题
 */
public class ABATest {

    public static AtomicReference<String> atomicReference = new AtomicReference<>("abc");


    public static void main(String[] args) throws InterruptedException {

        // 实现aba问题
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                atomicReference.compareAndSet("abc", "def");
                System.out.println("当前的值为： " + atomicReference.get());
                atomicReference.compareAndSet("def", "abc");
            }
        });

        Thread thread1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicReference.compareAndSet("abc", "123");
        });

        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
        System.out.println(atomicReference.get());
    }
}
