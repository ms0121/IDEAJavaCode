package com.liu.day3;

import java.util.List;

/**
 * @author lms
 * @date 2021-07-05 - 13:12
 */
public class NC53 {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode p = root;
        int n = 2;
        for (int i = 2; i <= n; i++) {
            ListNode listNode = new ListNode(i);
            p.next = listNode;
            p = listNode;
        }
        traverse(root);
        ListNode listNode = removeNthFromEnd(root, 2);
        traverse(listNode);
    }

    /**
     *
     * @param head ListNode类
     * @param n int整型
     * @return ListNode类
     */
    public static ListNode removeNthFromEnd (ListNode head, int n) {

        if (getLength(head) == n){
            head = head.next;
            return head;
        }

        ListNode p = head, q = head;
        int i = 0;

        // 找出前后两个游标之间的距离 == n,然后连个游标不断往后移动，直到后面的游标的next为null停止
        while (i < n){
            q = q.next;
            i++;
        }

        while (q.next != null){
            q = q.next;
            p = p.next;
        }
        p.next = p.next.next;
        return head;

    }

    public static int getLength(ListNode head){
        int i = 0;
        ListNode p = head;
        while (p != null){
            i++;
            p = p.next;
        }
        return i;
    }


    public static void traverse(ListNode head){
        ListNode p = head;
        while (p != null){
            System.out.print(p.val + "--> ");
            p = p.next;
        }
        System.out.println();
    }

}
