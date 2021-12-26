package com.liu.day;

/**
 * @author lms
 * @date 2021-03-26 - 21:47
 */
public class dp {
    public static void main(String[] args) {
        System.out.println("当前是动态规划算法： ");
        int num = louti(7);
        System.out.println(num);
    }

    // 计算爬楼梯的最多的方法
    public static int louti(int n) {
        if (n < 1) {
            return n;
        }
        // 记录已经走过的路径
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[n] = dp[n - 1] + dp[n - 2];
        }
        return dp[n - 1];
    }
}










