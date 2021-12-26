package com.liu.day3;

import java.util.Arrays;

/**
 * @author lms
 * @date 2021-08-13 - 23:34
 */
public class NC73 {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 2, 2, 2, 5, 4};
        int i = MoreThanHalfNum_Solution2(arr);
        System.out.println("map = " + i);
    }

    public static int MoreThanHalfNum_Solution2(int[] array) {
        int val = 0, count = 0;
        for (int i : array) {
            if (count == 0) {
                val = i;
                count++;
            } else {
                if (i == val) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return val;
    }


    public static int MoreThanHalfNum_Solution(int[] array) {
        Arrays.sort(array);
        int len = array[array.length - 1];
        int[] data = new int[len + 1];

        for (int i = 0; i < array.length; i++) {
            data[array[i]] = data[array[i]] + 1;
        }

        int max = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] > max) {
                max = i;
            }
        }
        return max;
    }
}
