package com.liu.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author lms
 * @date 2021-04-01 - 8:07
 */
public class LC628 {
    public static void main(String[] args) {
        int[] nums = {-100, -98, -1, 2, 3, 4};
        int maximumProduct = maximumProduct(nums);
        System.out.println("maximumProduct = " + maximumProduct);
    }

    // 寻找数组中最大的三个数
    public static int maximumProduct(int[] nums) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i : nums) {
            arrayList.add(i);
        }
        // 重写排序的方法
        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(Arrays.asList(arrayList));
        int res = 1;
        for (int i = 0; i < 3; i++) {
            res *= arrayList.get(i);
        }
        return res;
    }
}
