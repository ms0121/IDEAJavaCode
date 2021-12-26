package com.liu.thread.producer;

/**
 * @author lms
 * @date 2021-10-12 - 21:09
 * 用户模拟实现生产者和消费者
 * 即：如果值存在，就进行等待消费者进行消费，否则进行生产
 */
public class ProValue {

    private String value = "";

    // 定义方法修改value的字段值
    public void setValue(){
        synchronized (this){
            // 如果value不是""空串就等待
            while (!value.equalsIgnoreCase("")){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // value是空串，则执行赋值的操作
            String value = System.currentTimeMillis() + " - " + System.nanoTime();
            System.out.println("set设置的值是: " + value);
            this.value = value;
            // 唤醒编程
            // notify在多生产者和消费者的环境中，notify不能保证是生产者唤醒消费者，
            // 如果生产者唤醒的还是生产者，就有可能出现假死的情况，
            // this.notify();
            this.notifyAll();
        }
    }


    public void  getValue(){
        synchronized (this){
            // 如果当前value的值是空串，就等待赋值
            while (value.equalsIgnoreCase("")){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 不是空串，读取字段值
            System.out.println("get的值是: " + this.value);
            this.value = "";
            this.notifyAll();
        }
    }
}
