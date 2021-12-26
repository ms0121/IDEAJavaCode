package com.nk.day1;

import java.util.Stack;

/**
 * @author lms
 * @date 2021-10-07 - 15:59
 */
public class NC21 {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode node1 = new ListNode(2);
//        ListNode node2 = new ListNode(3);
//        ListNode node3 = new ListNode(4);
//        ListNode node4 = new ListNode(5);

        root.next = node1;
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;

        printRevers.traverse(root);
        System.out.println();

        ListNode node = reverseBetween(root, 1, 2);

        printRevers.traverse(node);

    }

    // 直接使用栈的方式进行指定区间的翻转
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        // 用于存放需要翻转部分的节点
        Stack<ListNode> stack = new Stack<>();
        ListNode pHead = null, cur = null;
        // 因为是位序，所以从 1 开始计数
        int i = 1;
        while (i < m) {
            if (pHead == null) {
                pHead = head;
                head = head.next;
                cur = pHead;
            } else {
                cur.next = head;
                cur = head;
                head = head.next;
            }
            i++;
        }
        // 将指定区间的节点入栈
        while (i <= n && head != null) {
            stack.push(head);
            head = head.next;
            i++;
        }
        // 节点出栈
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            if (pHead == null) {
                pHead = node;
                cur = pHead;
            } else {
                cur.next = node;
                cur = node;
            }
        }
        if (head != null) {
            cur.next = head;
        } else {
            cur.next = null;
        }
        return pHead;
    }
}
