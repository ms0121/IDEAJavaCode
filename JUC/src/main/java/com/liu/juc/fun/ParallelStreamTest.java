package com.liu.juc.fun;

import java.util.stream.LongStream;

/**
 * @author lms
 * @date 2021-09-05 - 21:19
 * 并行流计算
 */
public class ParallelStreamTest {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        // 计算0-10亿的和，使用并行流可以大幅度提高效率
        long sum = LongStream.rangeClosed(0L, 10_000_00L).parallel().reduce(0, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println("sum= " + sum + " time: " + (end - start));
    }
}
