package com.thread.day1;

/**
 * @author lms
 * @date 2021-08-27 - 12:57
 */
public class TickerDemo implements Runnable{

    private Integer ticket = 10;

    @Override
    public void run() {
        while (true){
            if (ticket < 0){
                break;
            }
            // 模拟延时操作
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "拿到了第 " + ticket-- + " 票");
        }
    }

    public static void main(String[] args) {
        TickerDemo tickerDemo = new TickerDemo();
        Thread thread = new Thread(tickerDemo, "小明");
        Thread thread1 = new Thread(tickerDemo, "老师");
        Thread thread2 = new Thread(tickerDemo, "黄牛");
        thread.start();
        thread1.start();
        thread2.start();
    }
}
