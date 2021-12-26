package com.liu.day4;

/**
 * @author lms
 * @date 2021-08-26 - 17:45
 */
public class NC_27 {
    public static void main(String[] args) {
        String str = "abc1234321ab";
        int longestPalindrome = get(str, 12);
        System.out.println("longestPalindrome = " + longestPalindrome);
    }

    // 求最长回文子串
    public static int getLongestPalindrome(String A, int n) {
        StringBuilder B = new StringBuilder(A).reverse();
        String C = new String(B);
        int[][] dp = new int[n + 1][n + 1];
        int maxLen = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (A.charAt(i-1) == C.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                if (maxLen <= dp[i][j]){
                    maxLen = dp[i][j];
                }
            }
        }
        return maxLen;
    }

    public static int get(String A, int n){
        StringBuilder B = new StringBuilder(A).reverse();
        String C = new String(B);
        int[][] arr = new int[A.length() + 1][A.length() + 1];
        int maxLen = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (A.charAt(i-1) == C.charAt(j-1)){
                    arr[i][j] = arr[i-1][j-1] + 1;
                }
                if (maxLen < arr[i][j]){
                    maxLen = arr[i][j];
                }
            }
        }
        return maxLen;
    }
}
