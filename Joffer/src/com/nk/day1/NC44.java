package com.nk.day1;

/**
 * @author lms
 * @date 2021-09-12 - 19:34
 */
public class NC44 {
    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        boolean cycle = hasCycle(node);
        System.out.println("cycle = " + cycle);
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        // 定义一个快慢指针，
        ListNode slow = head, fast = head.next;
        while (fast != null) {
            // 如果快慢指针相遇，这说明存在环。
            if (slow == fast) {
                return true;
            } else {
                // 否则让快慢指针都往后移动，快指针每次快一步
                slow = slow.next;
                if (fast.next == null){
                    return false;
                }
                fast = fast.next.next;
            }
        }
        // 跳出了循环，说明存在环
        return false;
    }
}
