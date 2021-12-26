package com.liu.thread.lock.reentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author lms
 * @date 2021-10-18 - 8:51
 * 读写锁
 */
public class TestRRW {

    static class Service {
        ReentrantReadWriteLock readLock = new ReentrantReadWriteLock();

        // 模拟读锁的共享性
        public void read(){
            try {
                // 获取读锁
                readLock.readLock().lock();
                System.out.println(Thread.currentThread().getName() + ", 读取数据：" + System.currentTimeMillis());
                // 延迟3秒钟
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("数据读取完毕.............");
                // 释放锁
                readLock.readLock().unlock();
            }
        }


        // 模拟写的互斥性
        public void write(){
            try {
                // 获取写锁
                readLock.writeLock().lock();
                System.out.println(Thread.currentThread().getName() + ", 开始写数据：" + System.currentTimeMillis());
                // 延迟3秒钟
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("数据修改完毕.............");
                // 释放锁
                readLock.writeLock().unlock();
            }
        }

    }

    public static void main(String[] args) {
        Service service = new Service();
        // 创建5个线程，从获得锁的时间可以看到，读锁可以被多个线程同时获取，证明了读锁的共享性
        // 写锁它是互斥的，同一时间只允许有一个线程获取锁对象，其他的线程必须进行等待写锁的释放才可以
        // 获取到写锁，从例子中可以看到每个线程在指定的时间间隔内才能进行写操作
//        for (int i = 0; i < 5; i++) {
//            new Thread(() -> {
//                service.write();
//            }).start();
//        }


        // 定义两个线程模拟写锁和读锁的同时使用，从结果中可以看到，读写锁是互斥的，必须等待其中的一个锁释放
        // 以后才可以获取另外一个锁对象,实现了读写的互斥
        new Thread(() -> {
            service.read();
        }).start();

        new Thread(() -> {
            service.write();
        }).start();

    }
}
