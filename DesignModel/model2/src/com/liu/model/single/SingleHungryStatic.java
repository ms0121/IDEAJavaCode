package com.liu.model.single;

/**
 * @author lms
 * @date 2021-08-31 - 17:12
 */
public class SingleHungryStatic {
    public static void main(String[] args) {
        SingleHungryS instance = SingleHungryS.getInstance();
        SingleHungryS instance1 = SingleHungryS.getInstance();

        System.out.println("instance.hashCode() = " + instance.hashCode());
        System.out.println("instance1.hashCode() = " + instance1.hashCode());

    }
}


//使用静态代码块的方式实现对象的创建
class SingleHungryS {

    // 1.私有化构造方法
    private SingleHungryS() {
    }

    // 2.创建静态变量
    private static SingleHungryS instance;

    // 使用静态代码块实现对象的创建（静态代码块会随着类的加载而执行一遍）
    static {
        instance = new SingleHungryS();
    }

    // 3.提供一个公有的静态方法，返回实例对象
    public static SingleHungryS getInstance() {
        return instance;
    }
}
