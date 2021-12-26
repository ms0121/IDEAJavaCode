package com.liu.juc.day2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author lms
 * @date 2021-09-04 - 12:17
 * 读写锁
 * 问题：手写一个缓存结构，实现数据的存取操作（要求写的时候单线程，读取的时候多线程）
 *
 * 独占锁(写锁)：一次只能被一个线程占用
 * 共享锁(读写)：多个线程可以同时占有
 *
 */
public class ReadWriteLockTest {
    public static void main(String[] args) {

        MyCacheLock myCacheLock = new MyCacheLock();
        for (int i = 1; i <= 6; i++) {
            final int tmp = i;
            new Thread(() -> {
                myCacheLock.push(String.valueOf(tmp), tmp);
            }, String.valueOf(tmp)).start();
        }

        System.out.println("=================================");

        for (int i = 1; i <= 6; i++) {
            final int tmp = i;
            new Thread(() -> {
                myCacheLock.pop(String.valueOf(tmp));
            }, String.valueOf(tmp)).start();
        }

    }
}

// 读写分离的实际就是直接使用锁的方式进行实现的，但是在很多的场景下是有一定的区别，
//比如在面试当中的回答，共享锁和独占锁的就是我们常说的读写锁，在进行写操作的时候，
//只允许单线程进行，在读的时候，试运行多线程进行操作
class MyCacheLock{

    private volatile Map<String, Object> map = new HashMap<>();
    // 读写锁,ReentrantReadWriteLock实现了ReadWriteLock这个类
    // 读写锁：更加细粒度的控制
    private ReentrantReadWriteLock reentrantReadWriteLock =
            new ReentrantReadWriteLock();

    // 存写操作的时候，只希望同时只能有一个线程在执行
    public void push(String key, Object value){
        // 添加锁
        reentrantReadWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "正在写 " + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "完成写入操作 ");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放锁
            reentrantReadWriteLock.writeLock().unlock();
        }
    }

    // 取出来，读操作，所有人都可以进行读取
    public void pop(String key){
        // 设置读操作的锁
        reentrantReadWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "正在读取 " + key);
            map.get(key);
            System.out.println(Thread.currentThread().getName() + "完成读取的操作 ");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放锁
            reentrantReadWriteLock.readLock().unlock();
        }
    }
}



//不使用读写锁的时候会出现线程之间的抢占问题，导致并没有按照我们的预想进行正确的读写操作
//所以我们需要添加正确的读写锁，目的就是为了让写入操作时单线程的，读取的时候可以是多线程进行读取
class MyCache{

    private volatile Map<String, Object> map = new HashMap<>();

    public void push(String key, Object value){
        System.out.println(Thread.currentThread().getName() + "正在写 " + key);
        map.put(key, value);
        System.out.println(Thread.currentThread().getName() + "完成写入操作 ");
    }

    public void pop(String key){
        System.out.println(Thread.currentThread().getName() + "正在读取 " + key);
        map.get(key);
        System.out.println(Thread.currentThread().getName() + "完成读取的操作 ");
    }
}
