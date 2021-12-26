package com.liu.juc.day1;
/**
 * @author lms
 * @date 2021-09-03 - 16:32
 * 生产者好消费者的问题（显示线程通信）
 * 线程之间对的通信问题，生产者和消费者，等待唤醒，通知唤醒
 * 线程之间的交替执行
 * Synchronized和wait()以及notifyAll()方法结合一起使用
 */
public class SynProConTest {
    public static void main(String[] args) {
        Data data = new Data();


        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                try {
                    data.increament();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                try {
                    data.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                try {
                    data.increament();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                try {
                    data.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }
}


//生产者和消费者问题： 等待，业务，唤醒
class Data{

    private int num = 0;

    // 现在要求生产者执行加1 的操作，消费者进行减1的操作
    // 这里只能使用while而不能使用if
    public synchronized void increament() throws InterruptedException {
        while (num != 0){
            // 等待消费者消费
            // 等待的部分逻辑必须放在循环语句中，否则有可能会出现虚假等待
            this.wait();
        }
        // 生产者，执行业务
        num++;
        System.out.println(Thread.currentThread().getName() + " --> " + num);
        // 唤醒，消费者
        this.notifyAll();
    }

    public synchronized void decrease() throws InterruptedException {
        while (num == 0){
            // 等待生产者生产
            this.wait();
        }
        // 生产者，执行业务
        num--;
        System.out.println(Thread.currentThread().getName() + " --> " + num);
        // 唤醒，消费者
        this.notifyAll();
    }
}

