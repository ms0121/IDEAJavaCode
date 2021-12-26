package com.liu.day4;

import java.util.Stack;

/**
 * @author lms
 * @date 2021-08-24 - 22:54
 */
public class NC_96 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        boolean pail = isPail(head);
        System.out.println("pail = " + pail);
    }

    public static boolean isPail (ListNode head) {
        Stack<ListNode> stack = getStack(head);
        while (!stack.isEmpty() && head != null){
            if (stack.peek().val != head.val){
                return false;
            }else {
                head = head.next;
                stack.pop();
            }
        }
        return true;
    }

    public static Stack<ListNode> getStack(ListNode head){
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        return stack;
    }
}
