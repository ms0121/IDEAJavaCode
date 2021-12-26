package com.liu.juc.fun;

import java.util.function.Consumer;

/**
 * @author lms
 * @date 2021-09-05 - 16:20
 * 消费型接口：只有输入，没有返回值
 */
public class ConsumerTest {
    public static void main(String[] args) {
        // 消费者型接口,只有参数的输入，没有返回值
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String str) {
                System.out.println("str = " + str);
            }
        };


        // lambda表达式
        Consumer<String> consumer1 = (str) -> {System.out.println("str = " + str);};

        consumer.accept("hello");
        consumer1.accept("world!");
    }
}
