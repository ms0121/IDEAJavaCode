package com.liu.juc.volatile1;

import java.util.concurrent.TimeUnit;

/**
 * @author lms
 * @date 2021-09-06 - 13:19
 * 下面的例子还没有使用volatile关键字的
 */
public class JMMTest {
//    不使用volatile会造成循环一直在执行（）
//    private static int num = 0;

//   添加volatile可以保证可见性
    private static volatile int num = 0;


    /**
     * 设置两个线程，一个main线程，另外一个线程
     * 分别读取类中的某个属性值，只有不满足要求的时候记性退出
     * @param args
     */
    public static void main(String[] args) {

        // 线程1,不会读取到main线程修改后num的值
        // 这样子就会造成在不断的执行循环，解决办法，设置为volatile
        new Thread(() -> {
            while (num == 0){
            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 主线程
        num = 1;
        System.out.println("num = " + num);
    }
}
