package com.thread.day1;

/**
 * @author lms
 * @date 2021-09-02 - 22:47
 *
 * 产生死锁的四个条件：
 *  1.互斥条件：一个资源每次只能被多个进程使用
 *  2.请求域保持条件：一个进程因请求资源而发生阻塞，对已获得到的资源保持不放
 *  3.不剥夺条件：进程已获得的资源，在未使用完之前，不能强行剥夺
 *  4.循环等待条件：若干进程之间形成了一种头尾相接的循环等待资源关系
 *
 */
public class DeadLockTest {
    public static void main(String[] args) {
        Makeup makeup = new Makeup(0, "小明");
        Makeup makeup1 = new Makeup(1,"小红");
        makeup.start();
        makeup1.start();
    }
}

//化妆模拟死锁的状态
class Makeup extends Thread {
    // 保证只有一份资源，使用static
    private static Lipstick lipstick = new Lipstick();
    private static Mirror mirror = new Mirror();

    private int choice;
    private String name;

    public Makeup(int choice, String name){
        this.choice = choice;
        this.name = name;
    }


    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 解决死锁的问题，让同一个线程不能同时持有两个及以上对象的锁
    public void makeup() throws InterruptedException {
        if (choice == 0) {
            // 拿到镜子
            synchronized (lipstick) {
                System.out.println(this.name + "拿到了口红....");
                Thread.sleep(100);
            }
            synchronized (mirror) {
                System.out.println(this.name + "又拿到了镜子....");
            }
        } else {
            if (choice == 1) {
                // 拿到镜子
                synchronized (mirror) {
                    System.out.println(this.name + "拿到了镜子....");
                    Thread.sleep(100);
                }
                synchronized (lipstick) {
                    System.out.println(this.name + "又拿到了口红....");
                }
            }
        }
    }


    // 模拟出现两个资源互相等待对方释放锁(从而出现了死锁)，一个资源被多个线程使用，从而造成了死锁的发生
//    public void makeup() throws InterruptedException {
//        if (choice == 0) {
//            // 拿到镜子
//            synchronized (lipstick) {
//                System.out.println(this.name + "拿到了口红....");
//                Thread.sleep(100);
//
//                synchronized (mirror) {
//                    System.out.println(this.name + "又拿到了镜子....");
//                }
//            }
//        } else {
//            if (choice == 1) {
//                // 拿到镜子
//                synchronized (mirror) {
//                    System.out.println(this.name + "拿到了镜子....");
//                    Thread.sleep(100);
//                    synchronized (lipstick) {
//                        System.out.println(this.name + "又拿到了口红....");
//                    }
//                }
//            }
//        }
//    }
}

// 口红
class Lipstick {
}

// 镜子
class Mirror {
}





