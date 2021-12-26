package com.liu.day3;

import java.util.Stack;

/**
 * @author lms
 * @date 2021-08-11 - 17:59
 */
public class N52 {
    public static void main(String[] args) {
        String s = "[]}";
        boolean valid = isValid(s);
        System.out.println("valid = " + valid);
    }

    public static boolean isValid (String s) {
        // write code here
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ']' && !stack.isEmpty() && stack.peek() == '['){
                stack.pop();
            }else if (s.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '('){
                stack.pop();
            }else if (s.charAt(i) == '}' && !stack.isEmpty() && stack.peek() == '{'){
                stack.pop();
            }else {
                stack.push(s.charAt(i));
            }
        }

        if (stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
