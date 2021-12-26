package com.liu.model.proxy.staticProcy;

/**
 * @author lms
 * @date 2021-08-31 - 20:36
 */
public class Host implements Rent {
    @Override
    public void rent() {
        System.out.println("房东租房子..............");
    }
}
