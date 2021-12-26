package com.nk.day1;

/**
 * @author lms
 * @date 2021-09-12 - 21:16
 */
public class NC1 {
    public static void main(String[] args) {
        String s = "1", t = "99";
        String solve = solve(s, t);
        System.out.println("solve = " + solve);
    }

    // 大数加法
    public static String solve (String s, String t) {
        int x = 0, y = 0, carry = 0, sum;
        int i = s.length() - 1, j = t.length() - 1;
        StringBuilder builder = new StringBuilder();
        while (i >= 0 || j >= 0 || carry != 0){
            if (i >= 0){
                x = s.charAt(i) - '0';
            }
            if (j >= 0){
                y = t.charAt(j) - '0';
            }
            sum = x + y + carry;
            builder.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
            x = 0;
            y = 0;
        }
        return builder.reverse().toString();
    }
}
