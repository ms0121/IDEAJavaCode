package com.liu.day3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lms
 * @date 2021-07-05 - 13:50
 */
public class NC24 {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(1);
        root.next = l2;
        l2.next = l3;
        ListNode node = deleteDuplicates(root);
        show(node);
    }

    // 将有序链表中重复出现的节点去除
    public static ListNode deleteDuplicates (ListNode head) {
        return null;
    }

    public static void show(ListNode head) {
        while (head != null){
            System.out.println("head.val = " + head.val);
            head = head.next;
        }
    }
}
