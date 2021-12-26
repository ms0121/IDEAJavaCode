package com.nk.day1;

import java.util.Stack;

/**
 * @author lms
 * @date 2021-09-12 - 20:10
 */
public class NC52 {
    public static void main(String[] args) {
        String s = "()([])";
        boolean valid = isValid(s);
        System.out.println("valid = " + valid);
    }

    // 判断括号是否匹配
    public static boolean isValid (String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            // 右括号，栈非空，然后栈顶是左括号，则匹配成功出栈
            if (s.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '('){
                stack.pop();
            }else if (s.charAt(i) == ']' && !stack.isEmpty() && stack.peek() == '['){
                stack.pop();
            }else if (s.charAt(i) == '}' && !stack.isEmpty() && stack.peek() == '{'){
                stack.pop();
            }else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
