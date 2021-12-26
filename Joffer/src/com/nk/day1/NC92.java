package com.nk.day1;

/**
 * @author lms
 * @date 2021-10-07 - 16:38
 */
public class NC92 {
    public static void main(String[] args) {
        String str1 = "1A2C3D4B56", str2 = "B1D23A456A";
        String lcs = LCS(str1, str2);
        System.out.println("lcs = " + lcs);
    }

    // 求字符串的最长公共子序列
    public static String LCS(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // 找出最长的公共子序列
        StringBuilder sb = new StringBuilder();
        int l1 = len1, l2 = len2;
        while (l1 != 0 && l2 != 0) {
            if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1)) {
                sb.append(s1.charAt(l1 - 1));
                l1--;
                l2--;
            } else {
                // 大于说明dp[l1][l2]的值来源于左边，否则来源于上边
                if (dp[l1 - 1][l2] > dp[l1][l2 - 1]) {
                    l1--;
                } else {
                    l2--;
                }
            }
        }
        if (sb.length() == 0) {
            return "-1";
        }
        return sb.reverse().toString();
    }
}
