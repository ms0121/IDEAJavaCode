package com.liu.leetCode;

import java.util.Stack;

/**
 * @author lms
 * @date 2021-08-22 - 21:46
 */
public class L_20 {
    public static void main(String[] args) {
        String str = "()(){[(]}";
        boolean valid = isValid(str);
        System.out.println("valid = " + valid);
    }


    /**
     * 判断括号是否匹配
     * @param str
     * @return
     */
    public static boolean isValid(String str){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else {
                if (stack.isEmpty()){
                    return false;
                }else {
                    Character temp = stack.pop();
                    if (c == ')'){
                        if (temp != '('){
                            return false;
                        }
                    }else if (c == ']'){
                        if (temp != '['){
                            return false;
                        }
                    }else if (c == '}'){
                        if (temp != '{'){
                            return false;
                        }
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
