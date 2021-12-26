package com.liu.thread.threadlocal;

/**
 * @author lms
 * @date 2021-10-13 - 8:10
 */
public class Test01 {

    // 创建一个线程本地变量
    static ThreadLocal threadLocal = new ThreadLocal();

    static class subThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                // 设置线程关联的值
                threadLocal.set(Thread.currentThread().getName() + ", value" + i);
                // 调用get方法读取关联的值
                System.out.println(Thread.currentThread().getName() + ", " + threadLocal.get());
            }
        }
    }

    public static void main(String[] args) {
        subThread thread = new subThread();
        subThread thread1 = new subThread();

        thread.start();
        thread1.start();
    }
}
