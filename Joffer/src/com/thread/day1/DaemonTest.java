package com.thread.day1;

/**
 * @author lmss
 * @date 2021-09-02 - 21:36
 * 守护线程：比如记录操作日记，监控内容，垃圾回收等待
 *  1. 线程分为守护线程和用户线程
 *  2. 虚拟机必须确保用户线程执行完毕
 *  3. 虚拟机不用等到守护线程执行完毕
 */
public class DaemonTest {
    public static void main(String[] args) {
        God god = new God();
        Thread thread = new Thread(god);
        // 将thread线程设置在守护线程
        thread.setDaemon(true);
        // 启动守护线程
        thread.start();

        /**
         * 理论上说thread线程是不会停止的，但是由于其实守护线程，
         * 所以当用户线程停止执行的时候，守护线程也会跟着停止运行
         */

        // 用户线程
        Person person = new Person();
        new Thread(person).start();
    }

}

//用户线程
class Person implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("咋们一直都在努力学习.....");
        }
        System.out.println("努力永不放弃!");
    }
}



// 将其设置为守护线程
class God implements Runnable{
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(10);
                System.out.println("上帝一直在保佑着大家...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
