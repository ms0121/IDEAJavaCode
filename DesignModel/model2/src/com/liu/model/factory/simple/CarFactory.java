package com.liu.model.factory.simple;

/**
 * @author lms
 * @date 2021-08-30 - 17:08
 */
public class CarFactory {

    public static Car getCar(String name) {
        if (name.equals("五菱")) {
            return new Wuli();
        } else if (name.equals("特斯拉")) {
            return new Tesla();
        } else {
            return null;
        }
    }
}
