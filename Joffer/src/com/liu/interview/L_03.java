package com.liu.interview;

/**
 * @author lms
 * @date 2021-04-02 - 23:05
 */
public class L_03 {
    public static void main(String[] args) {
        String str = "Mr John Smith    ";
        int length = 13;
        String s = replaceSpaces(str, length);
        System.out.println("s = " + s);
    }

    public static String replaceSpaces(String S, int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) != ' '){
                stringBuilder.append(S.charAt(i));
            }else {
                stringBuilder.append("%20");
            }
        }
        return stringBuilder.toString();
    }
}
