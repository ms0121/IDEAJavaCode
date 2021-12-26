package com.liu.thread.p2;

/**
 * @author lms
 * @date 2021-10-09 - 16:31
 * 卖火车票
 */
public class TicketThread implements Runnable {

    // 直接使用普通变量的方式，无法保证原子性，所以可以使用原子性的变量
    // volatile 保证变量的内存可见性
    private static volatile int ticket = 30;

    // 原子类
//    AtomicInteger ticket = new AtomicInteger(30);

    @Override
    public void run() {
        // synchronized可以保证线程的安全(一般使用当前对象的)
        synchronized (this) {
            while (ticket > 0) {
                try {
                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName() + ", ticket = " + ticket);
                    ticket--;
                    // 减一操作
//                ticket.getAndDecrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
