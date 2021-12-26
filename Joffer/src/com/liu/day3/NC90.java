package com.liu.day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * @author lms
 * @date 2021-09-06 - 21:09
 */
public class NC90 {

    public static void main(String[] args) {
//     [3,4,2,3]
//     [3,3,2,2,3,3,4,0]
    }

    private static Stack<Integer> stack = new Stack<>();

    public void push(int node) {
            stack.push(node);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        ArrayList<Integer> list = new ArrayList<>();

        // 1,2,3,4,5,
        // 5,4,3,2,1
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }

        for (int i = list.size()-1; i >= 0; i--) {
            stack.push(list.get(i));
        }
        return Collections.min(list);
    }
}
