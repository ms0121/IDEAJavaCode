package com.liu.interview;

import java.util.ArrayList;

/**
 * @author lms
 * @date 2021-04-09 - 23:16
 */

public class L_10 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);

        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node6 = new ListNode(1);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node6;

        ListNode node5 = removeDuplicateNodes(node);
        show(node5);

    }


    public static void show(ListNode head) {
        while (head != null){
            System.out.println("head = " + head);
            head = head.next;
        }
    }

    public static ListNode removeDuplicateNodes(ListNode head) {
        if (head == null){
            return null;
        }

        ListNode cur = head;
        ArrayList<Integer> list = new ArrayList<>();
        while (cur != null){
            if (!list.contains(cur.val)){
                list.add(cur.val);
            }
            cur = cur.next;
        }

        System.out.println("list = " + list);

        head.val = list.get(0);
        cur = head;
        for (int i = 1; i < list.size(); i++) {
            ListNode node = new ListNode(list.get(i));
            cur.next = node;
            cur = cur.next;
        }
        return head;
    }
}
