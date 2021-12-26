package com.liu.leetCode;

import java.awt.*;
import java.lang.management.PlatformLoggingMXBean;
import java.util.List;

/**
 * @author lms
 * @date 2021-08-22 - 22:06
 * 合并两个链表
 */
public class L_21 {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        root.next = node1;
        node1.next = node2;

        ListNode root2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        root2.next = node3;
        node3.next = node4;

        ListNode merge = merge(root, root2);
        show(merge);

    }

    /**
     * 合并两个单调递增的链表
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode merge(ListNode l1, ListNode l2){
        ListNode root = null, cur = null, p = null;

        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                p = l1;
                l1 = l1.next;
            }else {
                p = l2;
                l2 = l2.next;
            }
            if (root == null){
                root = p;
                cur = p;
            }else {
                cur.next = p;
                cur = p;
            }
        }
        if (l2 != null){
            l1 = l2;
        }
        cur.next = l1;
        return root;
    }

    public static void show(ListNode root){
        if (root == null){
            return;
        }
        System.out.print(root.val + " -> ");
        show(root.next);
    }



}
