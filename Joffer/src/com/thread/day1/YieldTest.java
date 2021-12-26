package com.thread.day1;

/**
 * @author lms
 * @date 2021-09-01 - 23:01
 * yield线程礼让：
 *  1.礼让线程，让当前正在执行的线程暂停，但不阻塞
 *  2.蒋贤成从运行状态转为就绪状态
 *  3.让CPU重新进行调度，礼让不一定成功，看CPU的心情
 */
public class YieldTest {

    public static void main(String[] args) {
        MyTest myTest = new MyTest();

        /**
         * 说明，如果yield礼让成功，就是当a线程进入到yield方法之后，
         * 会暂停，重新回到就绪的状态，让CPU重新调度。
         * 所以顺序应该是  a开始，b开始，a结束，b结束或者其他
         */
        new Thread(myTest, "a").start();
        new Thread(myTest, "b").start();
    }

}

class MyTest implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 线程开始了");
        Thread.yield();  // 礼让线程
        System.out.println(Thread.currentThread().getName() + " 线程结束了");
    }
}




