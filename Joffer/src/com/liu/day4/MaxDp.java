package com.liu.day4;

/**
 * @author lms
 * @date 2021-08-19 - 19:24
 * 求出数组中的连续子序列的最大和
 * [3,-4,2,-1,2,6,-5,4]
 */
public class MaxDp {
    public static void main(String[] args) {
        int[] array = {3, -4, 2, -1, 2, 6, -5, 4};
        int max = max(array);
        System.out.println("max = " + max);
    }

    public static int max(int arr[]){
        int dp[] = new int[arr.length];
        int maxVal = 0;
        dp[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i] = Math.max(arr[i] + dp[i-1], arr[i]);
            if (dp[i] <= 0){
                dp[i] = 0;
            }
            if (maxVal < dp[i]){
                maxVal = dp[i];
            }
        }
        return maxVal;
    }
}
