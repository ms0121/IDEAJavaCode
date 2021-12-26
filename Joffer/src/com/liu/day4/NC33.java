package com.liu.day4;

import java.util.ArrayList;

/**
 * @author lms
 * @date 2021-08-19 - 20:44
 */
public class NC33 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node3;
        node3.next = node5;

        node2.next = node4;
        node4.next = node6;

        ListNode merge = Merge(node1, node2);
        show(merge);
    }

    public static void show(ListNode head){
        while (head != null){
            System.out.println("head.val = " + head.val);
            head = head.next;
        }
    }


    public static ListNode Merge(ListNode list1,ListNode list2) {
        ListNode p1 = list1,p2 = list2,r = null;
        list1 = null;
        ArrayList<Integer> list = new ArrayList<>();
        while (p1 != null && p2 != null){
            if (p1.val < p2.val){
                list.add(p1.val);
                p1 = p1.next;
            }else {
                list.add(p2.val);
                p2 = p2.next;
            }
        }
        if (p2 != null){
            p1 = p2;
        }
        while (p1 != null){
            list.add(p1.val);
            p1 = p1.next;
        }

        for (int i = 0; i < list.size(); i++) {
            ListNode node = new ListNode(list.get(i));
            if (list1 == null){
                node.next = list1;
                list1 = node;
                r = node;
            }else {
                r.next = node;
                r = node;
            }
        }
        return list1;
    }
}
