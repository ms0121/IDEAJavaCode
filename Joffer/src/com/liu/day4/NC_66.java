package com.liu.day4;

import java.util.HashMap;

/**
 * @author lms
 * @date 2021-08-25 - 10:30
 */
public class NC_66 {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(7);

        head1.next = node1;
        node1.next = node2;
        node2.next = node5;
        node5.next = node6;

        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode node = FindFirstCommonNode(head1, node3);
        show(node);

    }

    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        while (pHead1 != null){
            if (!map.containsValue(pHead1.val)){
                map.put(i, pHead1.val);
            }
            pHead1 = pHead1.next;
            i++;
        }

        while (pHead2 != null){
            if (map.containsValue(pHead2.val)){
                return pHead2;
            }else {
                pHead2 = pHead2.next;
            }
        }
        return null;
    }

    public static void show(ListNode head){
        ListNode cur = head;
        while (cur != null){
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
    }
}
