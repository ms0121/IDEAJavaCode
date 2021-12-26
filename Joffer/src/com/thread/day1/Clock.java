package com.thread.day1;

/**
 * @author lms
 * @date 2021-09-01 - 22:52
 */
//模拟时钟倒计时
public class Clock implements Runnable {

    private int count = 10;

    @Override
    public void run() {
        while (true){
            try {
                System.out.println(count--);
                Thread.sleep(1000);
                if (count <= 0){
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Clock clock = new Clock();
        clock.run();
    }

}
