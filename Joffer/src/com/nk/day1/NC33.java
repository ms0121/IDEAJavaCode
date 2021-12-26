package com.nk.day1;

/**
 * @author lms
 * @date 2021-09-12 - 13:52
 */
public class NC33 {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(10);
        ListNode node5 = new ListNode(20);
        ListNode head2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(6);
        ListNode node6 = new ListNode(7);

        head1.next = node1;
        node1.next = node2;
        node2.next = node5;

        head2.next = node3;
        node3.next = node4;
        node4.next = node6;

        ListNode merge = Merge(head1, head2);
        printRevers.traverse(merge);

    }

    // 合并两个排序的链表
    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null && list2 != null) {
            return list2;
        }
        if (list2 == null && list1 != null) {
            return list1;
        }

        ListNode head = null, cur = null;
        // 使用归并的思想，分别判断两个链表节点的值
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                if (head == null) {
                    head = list1;
                    cur = head;
                } else {
                    cur.next = list1;
                    cur = list1;
                }
                list1 = list1.next;
            } else {
                if (head == null) {
                    head = list2;
                    cur = head;
                } else {
                    cur.next = list2;
                    cur = list2;
                }
                list2 = list2.next;
            }
        }
        // 循环完毕，一定剩下一个链表没有遍历完成，将未遍历完的链表直接添加到新链表的末尾即可
        if (list2 != null) {
            list1 = list2;
        }
        if (list1 != null) {
            cur.next = list1;
        }
        return head;
    }
}
