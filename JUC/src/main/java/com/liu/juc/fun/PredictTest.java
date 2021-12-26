package com.liu.juc.fun;

import java.util.function.Predicate;

/**
 * @author lms
 * @date 2021-09-05 - 16:10
 * Predicate:断定型接口，有一个输入参数，返回值只能是布尔值
 */
public class PredictTest {
    public static void main(String[] args) {

        // 匿名内部类：断定型，用于判断的函数，有输出和输出
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String str) {
                return str.isEmpty();
            }
        };

        // lambda表达式
        Predicate<String> predicate1 = (str) -> {return str.isEmpty();};

        System.out.println("predicate.test() = " + predicate.test("hello"));
        System.out.println("predicate1.test() = " + predicate1.test("hdjh"));

    }
}
