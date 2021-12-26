package com.liu.day3;

/**
 * @author lms
 * @date 2021-09-06 - 22:27
 */
public class NC92 {
    public static void main(String[] args) {
        String str1 = "1A2C3D4B56", str2 = "B1D23A456A";
        String lcs = LCS(str1, str2);
        System.out.println("lcs = " + lcs);
    }

    // 求解最长公共子序列
    public static String LCS(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        // 先计算两者的动态表
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
        while (l1 != 0 && l2 != 0){
            // 从后往前遍历，判断两个字符串对应的字符是否相等
            if (s1.charAt(l1-1) == s2.charAt(l2-1)){
                sb.append(s1.charAt(l1-1));
                l1--;
                l2--;
            }else {
                // 如果不相等，则找出最后的长度
                if (dp[l1-1][l2] > dp[l1][l2-1]){
                    l1--;
                }else {
                    l2--;
                }
            }
        }
        if (sb.length() == 0){
            return "-1";
        }
        return sb.reverse().toString();
    }

}

