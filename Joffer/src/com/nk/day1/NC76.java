package com.nk.day1;

import java.util.Stack;

/**
 * @author lms
 * @date 2021-09-12 - 14:10
 */
public class NC76 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }else {
            return stack2.pop();
        }
    }

    public static void main(String[] args) {
        NC76 nc = new NC76();
        nc.push(1);
        nc.push(2);
        nc.push(3);
        nc.push(4);
        nc.push(5);
        System.out.println("nc.pop() = " + nc.pop());
        System.out.println("nc.pop() = " + nc.pop());
        System.out.println("nc.pop() = " + nc.pop());
        System.out.println("nc.pop() = " + nc.pop());
        System.out.println("nc.pop() = " + nc.pop());
    }


}
