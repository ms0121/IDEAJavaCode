package com.liu.day3;

import java.math.BigDecimal;

/**
 * @author lms
 * @date 2021-07-03 - 14:56
 */
public class NC1 {
    public static void main(String[] args) {
        String s = "1";
        String t = "99";
        String solve = solve(s, t);
        System.out.println("solve = " + solve);
    }

    // 实现两个字符串的相加 1 + 99 = 100
    public static String solve(String s, String t) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = s.length() - 1, j = t.length() - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i < 0 ? 0 : s.charAt(i--) - '0';
            int y = j < 0 ? 0 : t.charAt(j--) - '0';
            int sum = x + y + carry;
            stringBuilder.append(sum % 10);//添加到字符串尾部
            carry = sum / 10;
        }
        return stringBuilder.reverse().toString();//对字符串反转
    }
}
