package com.liu.day4;

/**
 * @author lms
 * @date 2021-08-22 - 19:25
 */

public class printRevers {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        root.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        revers(root);
    }


    /**
     * 链表的逆序打印
     * @param root
     */
    public static void revers(ListNode root){
        if (root == null){
            return;
        }
        revers(root.next);
        // 打印当前的节点
        System.out.println("root.val = " + root.val);
    }
}
