package com.nk.day1;

/**
 * @author lms
 * @date 2021-09-13 - 9:48
 */
public class NC103 {
    public static void main(String[] args) {
        String str = "abcd";
        String solve = solve(str);
        System.out.println("solve = " + solve);
    }

    public static String solve (String str) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            builder.append(str.charAt(i));
        }
        return builder.reverse().toString();
    }
}
