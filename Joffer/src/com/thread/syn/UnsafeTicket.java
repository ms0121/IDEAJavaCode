package com.thread.syn;

/**
 * @author lms
 * @date 2021-09-02 - 22:12
 */
// 线程不安全的情况
// 对于synchronized代码块，则是在多个共享对象的时候，使用同步代码块，对共同使用的对象进行锁
// synchronized(obj or .class(同步的对象))
public class UnsafeTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread thread1 = new Thread(ticket, "小明");
        Thread thread2 = new Thread(ticket, "小胡");
        Thread thread3 = new Thread(ticket, "黄牛党");

        thread1.start();
        thread2.start();
        thread3.start();

    }
}

//模拟线程不安全的买票过程
class Ticket implements Runnable{

    private int ticketNum = 10;

    // 用于停止线程
    private Boolean flag = true;


    /**
     * 添加synchronized关键字，让当前的方法属于同步方法，实现了线程安全，锁的是当前对象
     *同步方法中无需指定同步监视器，因为同步方法中的同步监视器就是this，就是这个对象本身，
     * 或者是class
     */
    @Override
    public synchronized void run() {
        while (flag){
            if (ticketNum <= 0){
                flag = false;
            }
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + "买到了 ==> " + ticketNum--);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
