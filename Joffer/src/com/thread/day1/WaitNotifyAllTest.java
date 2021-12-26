package com.thread.day1;

/**
 * @author lms
 * @date 2021-09-03 - 9:25
 * 生产者和消费者
 */
public class WaitNotifyAllTest {
    public static void main(String[] args) {
        Container container = new Container();
        new Producer(container).start();
        new Consumer(container).start();
    }
}

class Producer extends Thread{

    Container container;

    public Producer(Container container){
        this.container = container;
    }

    // 生产鸡
    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            System.out.println("生产了第  " + i + "只鸡");
            container.push(new Chicken(i));
        }
    }
}

class Consumer extends Thread{
    Container container;

    public Consumer(Container container){
        this.container = container;
    }

    // 消费鸡
    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            System.out.println("消费了-->" + container.pop().id );
        }
    }

}

class Chicken{
    public int id;
    public Chicken(int id) {
        this.id = id;
    }
}

class Container{
    // 设置容器中数组的大小
    private Chicken chickens[] = new Chicken[10];
    private int count = 0;

    // 生产者放入放入产品
    public synchronized void push(Chicken chicken){
        // 如果容器满了，则需要等待消费者进行消费
        if (count == chickens.length) {
            // 通知消费者消费，生成者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 如果没有满，生产者就进行生产丢入产品
        chickens[count] = chicken;
        count++;

        // 有生产的，就可以通知消费者进行消费了
        this.notifyAll();
    }

    // 消费者消费产品
    public synchronized Chicken pop(){
        // 如果已经消费完，则通知生产者，消费者进行等待
        if (count == 0) {
            // 通知生成者生产，消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 如果还可以消费
        count--;
        Chicken chicken = chickens[count];

        // 吃完了，通知生产者进行生产
        // 当前线程去唤醒其他的线程，即唤醒生产者进行生产
        this.notifyAll();
        // 将消费的进行返回
        return chicken;

    }


}





