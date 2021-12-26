package com.liu.model.factory.method;

import com.liu.model.factory.simple.Car;
import com.liu.model.factory.simple.Wuli;

/**
 * @author lms
 * @date 2021-08-30 - 17:25
 */
public class WuliFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new Wuli();
    }
}
