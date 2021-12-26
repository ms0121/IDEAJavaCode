package com.liu.interview;

/**
 * @author lms
 * @date 2021-04-09 - 23:12
 */
public class L_09 {
    public static void main(String[] args) {
        String s1 = "waterbottle", s2 = "erbottlewat";
        System.out.println("isFlipedString(s1, s2) = " + isFlipedString(s1, s2));
    }

    // 先判断长度是否相同，不相同返回false，其次拼接两个s2，则如果是由s1旋转而成，则拼接后的s一定包含s1.
    public static boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        String s = s2 + s2;
        return s.contains(s1);
    }
}
