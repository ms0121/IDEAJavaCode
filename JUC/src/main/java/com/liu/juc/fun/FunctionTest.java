package com.liu.juc.fun;

import java.util.function.Function;

/**
 * @author lms
 * @date 2021-09-05 - 15:55
 */
//函数式接口：就是只定义一个抽象方法的接口
public class FunctionTest {
    public static void main(String[] args) {
        // 匿名内部类，函数有一个输入值和一个输出值，输入输出值的类型由我们进行指定
        Function<String, String> function = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s;
            }
        };

        // 改写成为lambda表达式
        Function<String, String> function1 = (s) -> {return s;};

        System.out.println("function.apply() = " + function.apply("hdsjhj"));
        System.out.println("function1.apply() = " + function1.apply("lambda表达式"));
    }
}
