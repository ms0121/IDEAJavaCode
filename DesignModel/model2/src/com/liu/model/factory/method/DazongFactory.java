package com.liu.model.factory.method;

import com.liu.model.factory.simple.Car;

/**
 * @author lms
 * @date 2021-08-30 - 17:28
 */
public class DazongFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new Dazong();
    }
}
