package com.liu.leetCode;

/**
 * @author lms
 * @date 2021-08-22 - 22:40
 */
public class L_24 {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode node = new ListNode(2);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4);
        root.next = node;
        node.next = node1;
        node1.next = node2;

        ListNode head = swap(root);
        show(head);
    }

    /**
     * 实现单链表之间的两两交换
     * @param head
     * @return
     */
    public static ListNode swap(ListNode head){
        if (head == null || head.next == null){
            return null;
        }
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode cur = res;
        while (cur.next != null && cur.next.next != null){
            ListNode next = head.next;
            ListNode tmp = head.next.next;
            cur.next = next;
            next.next = head;
            head.next = tmp;
            cur = head;
            head = head.next;
        }
        return res.next;
    }

    /**
     * 递归进行遍历
     * @param root
     */
    public static void show(ListNode root){
        if (root == null){
            return;
        }
        System.out.print(root.val + " -> ");
        show(root.next);
    }
}
