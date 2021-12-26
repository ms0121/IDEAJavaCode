package com.liu.interview;

/**
 * @author lms
 * @date 2021-04-10 - 9:08
 */
public class L_13 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);

        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        int i = kthToLast(node, 2);
        System.out.println("i = " + i);
    }

    //    实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
    //    输入： 1->2->3->4->5 和 k = 2
    //    输出： 4
    public static int kthToLast(ListNode head, int k) {
        ListNode pre = head, q = head;
        int i = 0;
        while (q != null && i < k){
            q = q.next;
            i++;
        }

        while (q != null){
            q = q.next;
            pre = pre.next;
        }
        return pre.val;
    }
}
