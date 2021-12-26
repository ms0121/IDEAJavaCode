package com.liu.thread.p2;

/**
 * @author lms
 * @date 2021-10-09 - 16:33
 */
public class TicketTest {
    public static void main(String[] args) {
        TicketThread ticketThread = new TicketThread();
        Thread thread = new Thread(ticketThread);
        thread.setName("线程1");
        Thread thread1 = new Thread(ticketThread);
        thread1.setName("线程2");

        Thread thread2 = new Thread(ticketThread);
        thread2.setName("线程3");

        thread.start();
        thread1.start();
        thread2.start();

    }
}
