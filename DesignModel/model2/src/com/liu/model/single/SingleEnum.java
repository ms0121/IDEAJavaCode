package com.liu.model.single;

/**
 * @author lms
 * @date 2021-08-31 - 19:08
 */
public class SingleEnum {
    public static void main(String[] args) {
        SingleE instance = SingleE.INSTANCE;
        SingleE instance1 = SingleE.INSTANCE;

        System.out.println("instance.hashCode() = " + instance.hashCode());
        System.out.println("instance1.hashCode() = " + instance1.hashCode());
        instance.sayOk();
    }
}

/**
 * 使用的枚举的方式实现单例模式
 * 枚举的方式不仅能够避免多线程同步的问题，还可以防止反序列化重新创建新的对象
  */
enum  SingleE{
    INSTANCE;
    public void sayOk(){
        System.out.println("ok");
    }
}
