package com.liu.aop;

/**
 * @author lms
 * @date 2021-05-08 - 9:54
 */
public class MathCalculator {

    public int div(int i, int j) {
        System.out.println("com.liu.aop.MathCalculator.div被调用了.........");
        return i / j;
    }
}
