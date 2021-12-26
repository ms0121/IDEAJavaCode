package com.liu.model.factory.method;

import com.liu.model.factory.simple.Car;

/**
 * @author lms
 * @date 2021-08-30 - 17:27
 */
public class Dazong implements Car {

    @Override
    public void name() {
        System.out.println("大众");
    }
}
