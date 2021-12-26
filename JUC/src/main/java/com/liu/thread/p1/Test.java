package com.liu.thread.p1;

/**
 * @author lms
 * @date 2021-10-09 - 15:39
 */
public class Test {
    public static void main(String[] args) {

        Thread thread = new Thread("线程1");
        System.out.println("thread.isAlive() = " + thread.isAlive());
        thread.start();
        // 获取线程id
        System.out.println("thread.getId() = " + thread.getId());
        // 获取线程的名字
        System.out.println("thread.getName() = " + thread.getName());
        System.out.println("Thread.currentThread() = " + Thread.currentThread().getName());
        System.out.println("thread.getPriority() = " + thread.getPriority());
        // thread.isAlive()不一定是true或者false，因为要根据当前线程是否已停止来确定
        System.out.println("thread.isAlive() = " + thread.isAlive());

        System.out.println("start = " + System.currentTimeMillis());
        try {
            // 让线程休眠指定的时间：毫秒数
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread.isAlive() = " + thread.isAlive());
        System.out.println("end = " + System.currentTimeMillis());

    }
}
