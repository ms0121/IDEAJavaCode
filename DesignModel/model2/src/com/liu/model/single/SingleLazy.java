package com.liu.model.single;

/**
 * @author lms
 * @date 2021-08-31 - 17:20
 */
public class SingleLazy {
    public static void main(String[] args) {
        SingleL instance = SingleL.getInstance();
        SingleL instance1 = SingleL.getInstance();


        System.out.println("instance.hashCode() = " + instance.hashCode());
        System.out.println("instance1.hashCode() = " + instance1.hashCode());

    }
}

// 单例模式：懒汉式(线程不安全)，单线程下可以使用，多线程的情况下会出现线程不安全，所以在项目中不推荐使用
class SingleL {
    // 1.私有化构造方法
    private SingleL() {
    }

    // 2. 创建变量
    private static SingleL instance;

    // 3.给当前的静态变量进行赋值并进行返回
    public static SingleL getInstance() {
        // 先进行判断当前的对象是否存在，如果不存在则进行创建然后再返回对象，否则直接返回
        // 在这一步的时候可能会出现线程不安全的情况，假设当前有a,b两个线程都进入这个方法里面，
        // 此时a判断没有实例，就会进行创建，与此同时，在创建的时候，b也拿到了，发现也没有实例
        // 也会进行创建，那么此时就可能出现线程不安全的问题。
        if (instance == null) {
            instance = new SingleL();
        }
        return instance;
    }
}


// 单例模式：懒汉式(线程安全)，单线程下可以使用，多线程的情况下会出现线程安全，
// 但是效率太低，所以在项目中不推荐使用
class SingleL2 {
    // 1.私有化构造方法
    private SingleL2() {
    }

    // 2. 创建变量
    private static SingleL2 instance;

    // 3.给当前的静态变量进行赋值并进行返回
    // 加入了同步synchronized实现了线程的同步安全问题，但是效率太低，不推荐使用
    // 因为在多线程的情况下，加入a线程拿到了，此时其他的线程就必须在外进行等候a线程
    // 执行完毕，才可以执行下一个线程，个人理解就好像是使用队列的操作(个人理解，大佬勿喷)，
    public static synchronized SingleL2 getInstance() {
        // 先进行判断当前的对象是否存在，如果不存在则进行创建然后再返回对象，否则直接返回
        if (instance == null) {
            instance = new SingleL2();
        }
        return instance;
    }
}
