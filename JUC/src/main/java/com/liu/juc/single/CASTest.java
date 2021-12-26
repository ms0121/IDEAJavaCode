package com.liu.juc.single;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lms
 * @date 2021-09-06 - 16:06
 * CAS:比较当前工作内存中的值和主内存中的值，如果这个值是我们所期望的，那么就执行操作
 *      如果不是就一直循环!
 *
 * 缺点：
 *  1.循环会耗时
 *  2.一次性只能保证一个共享变量的原子性
 *  3.出现ABA的问题
 *
 */
public class CASTest {
    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(2021);
        // 意思是：如果当前变量的值是期望的2021，那么将它赋值为2022，否则不执行操作
        boolean flag = atomicInteger.compareAndSet(2021, 2022);
        System.out.println("flag = " + flag);
        System.out.println("atomicInteger = " + atomicInteger);


        boolean flag1 = atomicInteger.compareAndSet(2021, 2022);
        System.out.println("flag1 = " + flag1);
        System.out.println("atomicInteger = " + atomicInteger);

    }
}
