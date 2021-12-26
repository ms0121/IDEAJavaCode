package com.liu.model.single;

/**
 * @author lms
 * @date 2021-08-31 - 16:49
 */
public class SingleHungry {
    public static void main(String[] args) {
        SingleH instance = SingleH.getInstance();
        SingleH instance1 = SingleH.getInstance();

        System.out.println(instance == instance1);
        System.out.println("instance.hashCode() = " + instance.hashCode());
        System.out.println("instance1.hashCode() = " + instance1.hashCode());

    }
}


// 单例模式的，饿汉式方式，这种单例模式是可以使用的，但缺点就是可能造成内存的浪费
// 因为创建了这个类的对象，但是在整个项目的运行过程中可能并没有使用到创建的对象
// 进行构造器的私有化，创建对象，提供返回实例的方法
class SingleH {

    // 1.要实现单例模式，需要设置构造器私有化，禁止外部使用new创建实例对象
    private SingleH() {
    }

    // 2.使用静态方式创建本类内部的对象
    private static final SingleH instance = new SingleH();

    // 3.提供一个公有的静态方法，返回实例对象
    public static SingleH getInstance() {
        return instance;
    }
}

