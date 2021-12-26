package com.liu.model.factory.method;

import com.liu.model.factory.simple.Car;

/**
 * @author lms
 * @date 2021-08-30 - 17:25
 * 工厂方法模式：添加Car的时候，不需要更改原有的代码方式
 */
public class MethodTest {
    public static void main(String[] args) {
        //
        Car car = new WuliFactory().getCar();
        Car car1 = new TeslaFactory().getCar();

        // 拓展新车
        Car car2 = new DazongFactory().getCar();

        car.name();
        car1.name();
        car2.name();
    }
}
