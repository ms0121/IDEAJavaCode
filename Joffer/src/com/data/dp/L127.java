package com.data.dp;

/**
 * @author lms
 * @date 2021-09-07 - 22:13
 * <p>
 * 计算最长公共子串
 */
public class L127 {
    public static void main(String[] args) {
        String str1 = "1AB2345CD", str2 = "12345EF";
        String lcs = LCS(str1, str2);
        System.out.println("lcs = " + lcs);
    }

    // 动态规划查找最长公共子串
    public static String LCS(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        int maxLen = 0, index = 0;
        for (int i = 1; i < str1.length() + 1; i++) {
            for (int j = 1; j < str2.length() + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (maxLen < dp[i][j]) {
                        maxLen = dp[i][j];
                        index = i;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        System.out.println("maxLen = " + maxLen);
        System.out.println("index = " + index);
        // str1.substring(a,b)代表的是起始位置
        return str1.substring(index - maxLen, index);
    }

}
