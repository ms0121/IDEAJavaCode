package com.liu.thread.ato;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author lms
 * @date 2021-10-10 - 8:37
 */
public class AtoArrayTest {
    public static void main(String[] args) {
        // 创建原子数组
        AtomicIntegerArray array = new AtomicIntegerArray(5);
        System.out.println(array); // [0, 0, 0, 0, 0]
        // 返回指定位置的元素值
        System.out.println(array.get(0)); // 0
        System.out.println(array.get(1)); // 0

        // 设置指定位置的元素值
        array.set(0, 3);
        System.out.println(array); // [3, 0, 0, 0, 0]
        // 设置数组元素的值时，同时返回数组中的旧值
        System.out.println(array.getAndSet(1, 9)); // 0
        System.out.println(array); // [3, 9, 0, 0, 0]
        // 先给指定位置的元素添加指定值，再返回该位置的值
        System.out.println(array.addAndGet(1, 9)); // 18
        System.out.println(array);

        // CAS操作
        // 如果数组中的某个值为期望的值，则将其位置的值进行修改为新值
        array.compareAndSet(0, 3, 200);  // [200, 18, 0, 0, 0]
        System.out.println(array); // [200, 18, 0, 0, 0]
        array.compareAndSet(1,  9,200);
        System.out.println(array); // [200, 18, 0, 0, 0]

        // 自增自减
        // 先增加1再返回值
        System.out.println(array.incrementAndGet(0)); // 201
        // 先返回值再添加1
        System.out.println(array.getAndIncrement(1)); // 18
        System.out.println(array); // [201, 19, 0, 0, 0]
        // 自减操作相同
        System.out.println(array.decrementAndGet(2)); // -1
        System.out.println(array.getAndDecrement(3)); // 0

    }
}
