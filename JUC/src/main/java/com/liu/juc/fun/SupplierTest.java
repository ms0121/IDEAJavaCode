package com.liu.juc.fun;

import java.util.function.Supplier;

/**
 * @author lms
 * @date 2021-09-05 - 16:23
 * Supplier:供给型接口，只有输出，没有输入
 */
public class SupplierTest {
    public static void main(String[] args) {
        // 供给型接口:没有输入，有输出，输出的类型由我们进行指定
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "hello";
            }
        };

        // lambda表达式
        Supplier<String> supplier1 = () -> {return "world";};

        String s = supplier.get();
        String s1 = supplier1.get();
        System.out.println("s = " + s);
        System.out.println("s1 = " + s1);
    }
}
