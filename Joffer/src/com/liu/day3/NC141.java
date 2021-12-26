package com.liu.day3;

/**
 * @author lms
 * @date 2021-08-15 - 9:07
 */
public class NC141 {
    public static void main(String[] args) {
        String str = "abcba";
        boolean judge = judge(str);
        System.out.println("judge = " + judge);
    }

    public static boolean judge (String str) {
        for (int i = 0, j = str.length() - 1; i <= j ; i++, j--) {
            if (str.charAt(i) != str.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
