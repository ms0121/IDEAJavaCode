package com.liu.model.factory.simple;

/**
 * @author lms
 * @date 2021-08-30 - 17:07
 *
 * 简单工厂模式：当要进行拓展新的Car时，就需要进行改动原有的代码
 */
public class CarTest {
    public static void main(String[] args) {
        // 不使用工厂，得全部自己进行创建
        // Tesla tesla = new Tesla();
        // Wuli wuli = new Wuli();

        // 使用简单工厂的方式进行创建
        // 使用工厂模式的好处就是，我们需要什么车就直接告诉工厂就可以了，我们不必要进行手动具体的创建车
        Car wuli = CarFactory.getCar("五菱");
        Car tesla = CarFactory.getCar("特斯拉");

        tesla.name();
        wuli.name();
    }
}
