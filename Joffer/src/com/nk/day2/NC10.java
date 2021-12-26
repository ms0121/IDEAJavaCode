package com.nk.day2;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author lms
 * @date 2021-09-19 - 13:24
 */
public class NC10 {
    public static void main(String[] args) {
        String s = "28", t = "99";
        String solve = solve(s, t);
    }


    public static String solve(String s, String t) {
        int carry = 0;
        int i = s.length() - 1, j = t.length() - 1;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        while (i >= 0) {
            int x = s.charAt(i) - '0';
            ArrayList<Integer> subList = new ArrayList<>();
            while (j >= 0 || carry != 0) {
                int y = 0;
                if (j >= 0){
                   y = t.charAt(j) - '0';
                }
                int sum = x * y + carry;
                subList.add(sum % 10);
                carry = sum / 10;
                j--;
            }
            j = t.length() - 1;
            list.add(subList);
            i--;
        }
        System.out.println("list = " + list);
        return null;
    }


    public static String solve1(String s, String t) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack1 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            int m = s.charAt(i) - '0';
            stack.push(m);
        }
        for (int i = 0; i < t.length(); i++) {
            int m = t.charAt(i) - '0';
            stack1.push(m);
        }
        Stack<Integer> tmpStack = stack;
        Stack<Integer> sumStack = new Stack<>();
        ArrayList<StringBuilder> list = new ArrayList<>();
        while (!stack1.isEmpty()) {
            int carry = 0;
            int x = stack1.pop();
            int y = 0;
            stack = tmpStack;
            while (!stack.isEmpty() || carry != 0) {
                if (!stack.isEmpty()) {
                    y = stack.pop();
                }
                int sum = x * y + carry;
                sumStack.push(sum % 10);
                carry = sum / 10;
            }
            StringBuilder builder = new StringBuilder();
            while (!sumStack.isEmpty()) {
                builder.append(sumStack.pop());
            }
            list.add(builder);
        }
        System.out.println("list = " + list);
        return "";
    }

}
