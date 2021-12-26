package com.nk.day1;

/**
 * @author lms
 * @date 2021-09-12 - 21:43
 */
public class NC127 {
    public static void main(String[] args) {
        String str1 = "1AB2345CD", str2 = "12345EF";
        String lcs = LCS(str1, str2);
        System.out.println("lcs = " + lcs);
    }

    // "1AB2345CD","12345EF"
    public static String LCS(String str1, String str2) {
        // 记录当前的dp数组
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        // 记录最大长度，以及终止的坐标值
        int maxLen = 0, index = 0;
        for (int i = 1; i < str1.length() + 1; i++) {
            for (int j = 1; j < str2.length() + 1; j++) {
                // 判断字符串中相等的字符
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    // 如果字符相等，则当前的dp值等于左对角线上的值 + 1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                // 判断最大长度
                if (maxLen < dp[i][j]){
                    maxLen = dp[i][j];
                    index = i;
                }
            }
        }
        // 使用最终的坐标和公共的长度进行截取
        return str1.substring(index - maxLen, index);
    }
}
