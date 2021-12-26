package com.liu.thread.p3;

/**
 * @author lms
 * @date 2021-10-10 - 14:04
 * wait()需要和synchronized同步锁一起使用
 */
public class WaitTest {
    public static void main(String[] args) {

        String str = "abc";
        System.out.println("同步前的代码:");
        synchronized (str){
            System.out.println("同步代码块开始......");
            try {
                // 调用wait方法后，线程会等待从而释放锁，当前线程需要被唤醒，如果没有唤醒将会一直阻塞
                str.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("同步代码块结束......");
        }
        str.notify();
        System.out.println("main线程之后的代码/////");

    }
}
