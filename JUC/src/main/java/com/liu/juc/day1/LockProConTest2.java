package com.liu.juc.day1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lms
 * @date 2021-09-03 - 18:55
 */
public class LockProConTest2 {
    public static void main(String[] args) {
        Data2 data = new Data2();

        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                data.printA();
            }
        }, "A").start();

        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                data.printB();
            }
        }, "B").start();

        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                data.printC();
            }
        }, "C").start();

    }
}

//实现线程的执行顺序
class Data2{

    private int num = 1;

    // 创建锁
    private Lock lock = new ReentrantLock();
    // 实现线程的等待开启
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void printA(){
        // 开启锁
        lock.lock();
        try {
            while (num != 1){
                // 当前线程等待
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName() + "AAAAAA");
            num = 2;
            // 唤醒condition2线程
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 解锁
            lock.unlock();
        }
    }

    public void printB(){
        // 开启锁
        lock.lock();
        try {
            while (num != 2){
                // 当前线程等待
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName() + "BBBBBB");
            num = 3;
            // 唤醒condition3线程
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 解锁
            lock.unlock();
        }
    }

    public void printC(){
        // 开启锁
        lock.lock();
        try {
            while (num != 3){
                // 当前线程等待
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName() + "CCCCCC");
            num = 1;
            // 唤醒condition1线程
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 解锁
            lock.unlock();
        }
    }

}

