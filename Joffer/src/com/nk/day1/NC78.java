package com.nk.day1;

/**
 * @author lms
 * @date 2021-09-12 - 9:49
 */
public class NC78 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);

        node.next = node1;
        node1.next = node2;

        ListNode listNode = ReverseList(node);
        printRevers.traverse(listNode);
    }

    // 1,2,3 ==> 3,2,1
    public static ListNode ReverseList(ListNode head) {
        if (head == null){
            return null;
        }
        // 反转链表，直接将每个节点的指针域指向前一个节点即可
        // 除了第一个节点的指针域指向为null
        ListNode cur = head, tmp;
        tmp = head.next;
        head.next = null;
        while (tmp != null){
            cur = tmp;
            tmp = tmp.next;
            cur.next = head;
            head = cur;
        }
        return cur;
    }
}
















