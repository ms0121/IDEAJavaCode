package com.liu.model.single;

/**
 * @author lms
 * @date 2021-08-31 - 17:49
 */
// 静态内部类实现单例模式的创建：解决了线程不安全的问题
public class SingleLazyPlusStatic {
    public static void main(String[] args) {
        SingleLazyPlusS instance = SingleLazyPlusS.getInstance();
        SingleLazyPlusS instance1 = SingleLazyPlusS.getInstance();

        System.out.println("instance.hashCode() = " + instance.hashCode());
        System.out.println("instance1.hashCode() = " + instance1.hashCode());
    }
}


// 单例模式：使用静态类的方式
// 优点：避免了线程不安全的问题，利用静态内部类的特点实现了延迟加载，效率比较高,推荐使用
class SingleLazyPlusS {
    // 1.私有化构造函数
    private SingleLazyPlusS() {
    }

    // 2.创建静态内部类(不会随着类的加载而加载)，只用执行getInstance()方法的时候才会执行静态内部类的创建
    private static class SingleTon {
        private static final SingleLazyPlusS INSTANCE = new SingleLazyPlusS();
    }

    // 3.执行调用实例的方法
    public static synchronized SingleLazyPlusS getInstance() {
        return SingleTon.INSTANCE;
}
}

