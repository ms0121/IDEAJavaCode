package com.liu.day4;

/**
 * @author lms
 * @date 2021-08-25 - 11:50
 */
public class NC_127 {
    public static void main(String[] args) {
        String s1 = "1AB2345CD";
        String s2 = "12345EF";
        String lcs = LCS(s1, s2);
        System.out.println("lcs = " + lcs);

    }

    /**
     * 计算最长公共子串
     * @param str1
     * @param str2
     * @return
     */
    public static String LCS (String str1, String str2) {
        // write code here
        int[][] arr = new int[str1.length() + 1][str2.length() + 1];
        int end = 0;
        int maxLen = 0;
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)){
                    arr[i][j] = arr[i-1][j-1] + 1;
                }
                if (maxLen < arr[i][j]){
                    maxLen = arr[i][j];
                    end = i;
                }
            }
        }
        return (String) str1.subSequence(end - maxLen, end);
    }
}
