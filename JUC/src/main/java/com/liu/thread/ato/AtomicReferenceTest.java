package com.liu.thread.ato;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author lms
 * @date 2021-10-10 - 9:34
 * 使用AtomicReference原子类读写一个对象
 */
public class AtomicReferenceTest {

    public static AtomicReference<String> atomicReference = new AtomicReference<>("abc");

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    if (atomicReference.compareAndSet("abc", "def")){
                        System.out.println(Thread.currentThread().getName() + " 修改为： " + "def");
                    }
                }
            }).start();
        }

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    if (atomicReference.compareAndSet("def", "abc")){
                        System.out.println(Thread.currentThread().getName() + " 修改为： " + "abc");
                    }
                }
            }).start();
        }

        System.out.println("end=======");
    }
}
