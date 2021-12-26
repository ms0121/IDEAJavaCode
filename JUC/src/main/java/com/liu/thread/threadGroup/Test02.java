package com.liu.thread.threadGroup;

/**
 * @author lms
 * @date 2021-10-18 - 9:46
 */
public class Test02 {
    public static void main(String[] args) {
        // 获取主线程组
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();

        // 创建子线程组
        ThreadGroup group1 = new ThreadGroup("group1");

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread());
            }
        };

        // 创建线程并指定线程所属的线程组(不指定默认是属于主线程组)
        Thread t1 = new Thread(runnable, "t1");
        Thread t2 = new Thread(group1, runnable, "t2");

        t1.start();
        t2.start();

        // 打印线程组的相关属性
        System.out.println("mainGroup.activeGroupCount() = " + mainGroup.activeGroupCount());
        System.out.println("mainGroup.getParent() = " + mainGroup.getParent());
        System.out.println("group1.activeGroupCount() = " + group1.activeGroupCount());
        System.out.println("group1.getParent() = " + group1.getParent());

        System.out.println(mainGroup.parentOf(mainGroup));
        System.out.println(mainGroup.parentOf(group1));
        System.out.println(group1.parentOf(mainGroup));

    }
}
