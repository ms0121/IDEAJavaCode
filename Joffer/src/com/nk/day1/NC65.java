package com.nk.day1;

/**
 * @author lms
 * @date 2021-09-13 - 9:55
 */
public class NC65 {
    public static void main(String[] args) {
        int fibonacci = Fibonacci(4);
        System.out.println("fibonacci = " + fibonacci);
    }

    public static int Fibonacci(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1 || n == 2){
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n - 1];
    }
}
