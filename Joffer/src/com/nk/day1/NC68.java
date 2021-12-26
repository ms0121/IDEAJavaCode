package com.nk.day1;

/**
 * @author lms
 * @date 2021-09-12 - 14:25
 */
public class NC68 {
    public static void main(String[] args) {
        int jumpFloor = jumpFloor(7);
        System.out.println("jumpFloor = " + jumpFloor);
    }

    // 动态规划
    public static int jumpFloor(int target) {
        if (target == 1){
            return 1;
        }

        int[] dp = new int[target];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < target; i++) {
            // 第i层阶梯的方法可以从(i-1)直接跳过来
            // 可以从(i-2)跳过来
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[target - 1];
    }

}
