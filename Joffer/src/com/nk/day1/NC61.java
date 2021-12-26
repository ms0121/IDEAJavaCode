package com.nk.day1;

import java.util.HashMap;

/**
 * @author lms
 * @date 2021-09-12 - 13:40
 */
public class NC61 {
    public static void main(String[] args) {
        int[] arr = {20, 70, 110, 150};
        int[] res = twoSum(arr, 90);
        for (int i = 0; i < res.length; i++) {
            System.out.println("res[i] = " + res[i]);
        }
    }

    public static int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            // 判断当前的map中是否存在值为(target - numbers[i])的元素
            if (!map.containsKey(target - numbers[i])) {
                // 不存在，直接将元素加入到hashMap中
                map.put(numbers[i], i);
            } else {
                return new int[]{map.get(target - numbers[i]) + 1, i + 1};
            }
        }
        return new int[]{};
    }
}
