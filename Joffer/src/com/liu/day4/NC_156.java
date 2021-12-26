package com.liu.day4;

import java.util.Arrays;

/**
 * @author lms
 * @date 2021-08-23 - 15:55
 */
public class NC_156 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 1, 5, 5, 1, 5};
        int number = foundOnceNumber(arr, 3);
        System.out.println("number = " + number);
    }

    /**
     * 找出数组中只出现过一次的数
     *
     * @param arr
     * @param k
     * @return
     */
    public static int foundOnceNumber(int[] arr, int k) {
        // write code here
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr[i + 1]) {
                i += k - 1;
            } else {
                return arr[i];
            }
        }
        return arr[arr.length - 1];
    }
}
