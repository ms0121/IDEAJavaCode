package com.liu.day3;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author lms
 * @date 2021-09-08 - 22:36
 */
public class NC91 {
    public static void main(String[] args) {
        int arr[] = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        LIS(arr);
    }

    public static int[] LIS(int[] arr) {
        if (arr.length == 0 || arr == null) {
            return new int[]{};
        }
        // 设置dp的初始值为1
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        int max = 1;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (dp[i] != 1){
                list.add(arr[i]);
            }
        }
        System.out.println("list = " + list);
        System.out.println("max = " + max);
        return null;
    }

}
