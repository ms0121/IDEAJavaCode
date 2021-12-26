package com.nk.day1;

/**
 * @author lms
 * @date 2021-09-13 - 10:15
 */
public class NC17 {
    public static void main(String[] args) {
        String str = "abc1234321ab";
        int palindrome = getLongestPalindrome(str, str.length());
        System.out.println("palindrome = " + palindrome);
    }

    // 暴力解法
    public static int getLongestPalindrome(String A, int n) {
        int maxLen = 0, index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i ; j < n; j++) {
                if (isPalindrome(A, i, j)){
                    int len = j - i + 1;
                    if (maxLen < len){
                        maxLen = len;
                        index = i;
                    }
                }
            }
        }
//        System.out.println("index = " + index);  // 回文子串的起始地址
//        System.out.println("maxLen = " + maxLen); // 回文子串的长度
//        System.out.println(A.substring(index, index + maxLen)); // 截取回文子串
        return maxLen;
    }

    // 判断是否是回文串
    private static boolean isPalindrome(String str, int i, int j) {
        while (i < j){
            if (str.charAt(i++) != str.charAt(j--)){
                return false;
            }
        }
        return true;
    }


}
