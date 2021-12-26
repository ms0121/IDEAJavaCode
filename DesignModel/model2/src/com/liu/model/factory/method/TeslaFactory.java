package com.liu.model.factory.method;

import com.liu.model.factory.simple.Car;
import com.liu.model.factory.simple.Tesla;

/**
 * @author lms
 * @date 2021-08-30 - 17:24
 */
public class TeslaFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new Tesla();
    }
}
