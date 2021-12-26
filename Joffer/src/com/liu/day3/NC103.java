package com.liu.day3;

import java.util.Stack;

/**
 * @author lms
 * @date 2021-07-03 - 14:48
 */
public class NC103 {
    public static void main(String[] args) {
//        String str = "abcd";
//        String solve = solve(str);
//        System.out.println("solve = " + solve);
        int sqrt = sqrt(5);
        System.out.println("sqrt = " + sqrt);
    }

    public static String solve (String str) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return new String(sb);
    }

    public static int sqrt (int x) {
        if (x == 0){
            return 0;
        }
        // write code here
        int i;
        for (i = 1; i < x; ) {
            if (i * i <= x && (i+1)*(i+1)<=x){
                i++;
            }else {
                break;
            }
        }
        return i;
    }

}
