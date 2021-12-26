package com.nk.day1;

import java.util.Stack;

/**
 * @author lms
 * @date 2021-09-12 - 14:52
 */
public class NC50 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(2);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);

        head.next = node;
        node.next = node1;
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = reverseKGroup(head, 3);
        printRevers.traverse(node4);
    }

    public static ListNode reverseKGroup (ListNode head, int k) {
        // 用栈来存放每个节点
        Stack<ListNode> stack = new Stack<>();
        Stack<ListNode> stack1 = new Stack<>();
        ListNode root = null, cur = null;
        int i = 0;
        while (head != null){
            // 每k个进行入栈
            while (i < k && head != null){
                stack.push(head);
                head = head.next;
                i++;
            }
            // 判断最后的一段是否满足k个，不满足按照原来顺序拼接
            if (stack.size() != k){
                while (!stack.isEmpty()){
                    stack1.push(stack.pop());
                }
                // 按原顺序拼接
                while (!stack1.isEmpty()){
                    ListNode node = stack1.pop();
                    node.next = null;
                    if (root == null){
                        root = node;
                        cur = node;
                    }else {
                        cur.next = node;
                        cur = node;
                    }
                }
            }
            // 栈不空，逆序输出拼接
            while (!stack.isEmpty()){
                ListNode node = stack.pop();
                node.next = null;
                if (root == null){
                    root = node;
                    cur = node;
                }else {
                    cur.next = node;
                    cur = node;
                }
            }
            // 每次更新i的值
            i = 0;
        }
        return root;
    }
}
