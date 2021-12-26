package com.liu.interview;

import java.awt.*;

/**
 * @author lms
 * @date 2021-04-10 - 16:51
 */
public class L_16 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);

        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
    }

    public static void deleteNode(ListNode node) {
        // 1、把被删除节点的下一个节点的值赋给被删除的节点
        node.val = node.next.val;
        // 2、被删除节点指向下下一个节点
        node.next = node.next.next;
    }
}







