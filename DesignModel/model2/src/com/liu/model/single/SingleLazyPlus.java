package com.liu.model.single;

/**
 * @author lms
 * @date 2021-08-31 - 17:38
 */
public class SingleLazyPlus {
    public static void main(String[] args) {
        SingleLP instance = SingleLP.getInstance();
        SingleLP instance1 = SingleLP.getInstance();


        System.out.println("instance.hashCode() = " + instance.hashCode());
        System.out.println("instance1.hashCode() = " + instance1.hashCode());

    }
}


// 单例模式的懒加载方式，实现双重检查，并加入了同步机制，保证线程安全，并解决了饿汉式的内存浪费问题，
// 同时又保证了代码的效率问题,项目中推荐使用的方式
class SingleLP {
    // 1.私有化构造函数
    private SingleLP() {
    }

    // 2。设置同步变量，此时加入了volatile关键字
    // volatile: 实现变量的内存可见性，避免了指令重排
    private static volatile SingleLP instance;

    // 3.对象的构建并返回,使用synchronized实现线程安全的问题，假设来了多个线程，a拿到了线程，
    // 加入此时实例为空，那么其他的线程需要在函数外进行等待，a线程将会执行实例的创建工作，a线程
    // 执行完毕，其他的线程看到实例不为空就会直接进行返回当前的实例
    public static synchronized SingleLP getInstance() {
        if (instance == null) {
            // synchronized的参数表示对谁进行同步
            synchronized (SingleLP.class) {
                if (instance == null) {
                    instance = new SingleLP();
                }
            }
        }
        return instance;
    }
}
