package com.nk.day1;

import java.util.Stack;

/**
 * @author lms
 * @date 2021-09-12 - 20:51
 */
public class NC53 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node5 = removeNthFromEnd(node, 5);
        printRevers.traverse(node5);
    }

    // 删除链表的第n个节点,直接使用栈的方式实现倒着计数和删除的操作
    public static ListNode removeNthFromEnd(ListNode head, int n){
        Stack<ListNode> stack = new Stack<>();
        // 将全部的节点进行入栈
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        // 设置为头结点
        head = null;
        // 将所有的节点进行出栈的操作
        int i = 0;
        while (!stack.isEmpty()){
            ListNode node = stack.pop();
            i++;
            // 判断是否是要删除的节点
            if (i != n){
                // 头插法进行链表的恢复操作
                node.next = head;
                head = node;
            }
        }
        return head;
    }


    // 删除链表的第n个节点
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        if (getLength(head) == n) {
            return head.next;
        }
        int i = 0;
        ListNode p = head, q = head;
        while (i < n && q != null) {
            q = q.next;
            i++;
        }
        while (q.next != null) {
            q = q.next;
            p = p.next;
        }
        p.next = p.next.next;
        return head;
    }

    // 计算当前链表的长度
    public static int getLength(ListNode head) {
        int i = 0;
        ListNode p = head;
        while (p != null) {
            i++;
            p = p.next;
        }
        return i;
    }
}
