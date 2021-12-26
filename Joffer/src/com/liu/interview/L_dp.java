package com.liu.interview;

/**
 * @author lms
 * @date 2021-04-04 - 18:07
 */
public class L_dp {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 1, 7, 8, 3};
        int sum = dpSum(arr);
        System.out.println("sum = " + sum);
    }

    // 计算数组中不相邻的和最大值
    public static int dpSum(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            // 当计算第i个元素的最大值的时候，其取决于前 1 个和前 2 个之间的最大值,如果取前一个就是dp[i-1]，
            // 如果取前 2 个就是 dp[i-2] + arr[i]
            dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 1]);
        }
        return dp[arr.length - 1];
    }
}
