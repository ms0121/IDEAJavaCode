package com.liu.day3;

import com.sun.org.apache.regexp.internal.REUtil;

/**
 * @author lms
 * @date 2021-09-09 - 20:14
 */
public class NC25 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node5 = deleteDuplicates(node);
        show(node5);
    }

    public static ListNode deleteDuplicates (ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode p = head, q = head.next, tmp = null;
        while (q != null){
            if (p.val == q.val){
                q = q.next;
                p.next = q;
            }else {
                tmp = q.next;
                p = q;
                q = tmp;
            }
        }
        return head;
    }

    public static void show(ListNode head){
        while (head != null){
            System.out.print(head.val + " --> ");
            head = head.next;
        }
    }
}
