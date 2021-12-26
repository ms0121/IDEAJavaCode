package com.liu.juc.single;

import java.util.concurrent.TimeUnit;

/**
 * @author lms
 * @date 2021-09-06 - 15:21
 */
public class LazySimple {
    // 构造器私有化
    private LazySimple(){
        // 多线程下测试线程单例
        System.out.println(Thread.currentThread().getName() + "ok");
    }

    private static LazySimple lazySimple;

    // private static Lock lock = new ReentrantLock();
    // 线程不安全
    // 可以使用synchronized保证单例模式的安全，但是这样子的效率不高
    // 还可以使用Lock加上锁的方式
    public static LazySimple getInstance(){
        if (lazySimple == null){
            // 先对当前类上锁
            synchronized (LazySimple.class){
                if (lazySimple == null){
                    lazySimple = new LazySimple();
                    /**
                     * 这一部分不是安全的，原因是可能出现指令重排的现象：
                     *  1.分配内存空间
                     *  2.执行构造方法，初始化对象
                     *  3.把这个对象执行这个空间
                     */
                }
            }
        }
        return lazySimple;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                LazySimple.getInstance();
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}
