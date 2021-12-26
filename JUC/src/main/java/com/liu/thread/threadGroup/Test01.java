package com.liu.thread.threadGroup;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

/**
 * @author lms
 * @date 2021-10-18 - 9:25
 * 测试线程组
 */
public class Test01 {
    public static void main(String[] args) {
        // 获取当前main线程的线程组
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        System.out.println("mainGroup = " + mainGroup);

        // 创建线程组(指定线程组的名称)
        ThreadGroup group1 = new ThreadGroup("group1");
        System.out.println("group1 = " + group1);

        // 创建线程组并指定父线程组和线程组的名称
        ThreadGroup group2 = new ThreadGroup(mainGroup, "group2");
        System.out.println("group2 = " + group2);

        // 当前的创建的线程组都是父线程组在的成员
        System.out.println(mainGroup == group1.getParent());
        System.out.println(mainGroup == group2.getParent());


        // 再创建线程的时候可以指定线程所属的线程组
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread());
            }
        };

        // 不指定线程组的线程默认是属于main线程组
        Thread t1 = new Thread(runnable, "t1");

        // 可以指定当前的线程所属的线程组
        Thread t2 = new Thread(group1, runnable, "t2");
        Thread t3 = new Thread(group2, runnable, "t3");

        System.out.println("t1 = " + t1); // t1 = Thread[t1,5,main]
        System.out.println("t2 = " + t2); // t2 = Thread[t2,5,group1]
        System.out.println("t3 = " + t3); // t3 = Thread[t3,5,group2]

    }
}
