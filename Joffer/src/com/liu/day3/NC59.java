package com.liu.day3;

/**
 * @author lms
 * @date 2021-08-13 - 18:10
 */
public class NC59 {
    public static void main(String[] args) {
        int arr[][] = {{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
        int sum = minPathSum(arr);
        System.out.println("sum = " + sum);
    }

    // 动态规划计算
    public static int minPathSum(int[][] matrix) {
        // write code here
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = matrix[0][0];

        // 第一行
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }

        // 第一列
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + matrix[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
