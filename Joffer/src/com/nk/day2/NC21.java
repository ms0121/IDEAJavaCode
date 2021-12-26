package com.nk.day2;


/**
 * @author lms
 * @date 2021-09-15 - 11:57
 */
public class NC21 {
    public static void main(String[] args) {

    }

    public ListNode reverseBetween (ListNode head, int m, int n) {
        // 创建一个哑结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // pre指向要翻转链表的前驱结点
        ListNode pre = dummy;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        // 将后面的节点不断插入到翻转位置
        head = pre.next;
        // 记录翻转首节点的下一个节点
        ListNode next;
        for (int i = m; i < n; i++) {
            next = head.next;
            // 固定的翻转首节点指向下下个节点，从而实现轮询向前插入节点
            head.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }
}
