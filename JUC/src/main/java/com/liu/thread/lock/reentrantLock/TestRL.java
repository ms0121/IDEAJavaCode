package com.liu.thread.lock.reentrantLock;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lms
 * @date 2021-10-14 - 16:56
 * 可重入锁：线程执行m1()方法，默认使用的同步锁对象是this对象，即调用该方法的实例对象testRL，在m1方法中，又调用了
 * 同步方法m2，此时m1的同步锁还没有进行释放，而m2方法的锁对象又是当前的这个对象testRL，那么线程可以多次获得同一个
 * 锁对象，这就是锁的重入性。
 */
public class TestRL {

    public synchronized void m1(){
        System.out.println("同步锁---方法1");
        m2();
    }

    private synchronized void m2() {
        System.out.println("同步锁---方法2");
        m3();
    }

    private synchronized void m3() {
        System.out.println("同步锁---方法3");
    }

    public static void main(String[] args) {
        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
        TestRL testRL = new TestRL();
        new Thread(new Runnable() {
            @Override
            public void run() {
                testRL.m1();
            }
        }).start();
    }
}
