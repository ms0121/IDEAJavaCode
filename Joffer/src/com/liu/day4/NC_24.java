package com.liu.day4;

import java.util.Stack;

/**
 * @author lms
 * @date 2021-08-23 - 17:46
 */
public class NC_24 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(2);
//        ListNode node4 = new ListNode(3);
//        ListNode node5 = new ListNode(4);
//        ListNode node6 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
        show(head);
        System.out.println();
        ListNode node = deleteDuplicates(head);
        show(node);
    }

    /**
     * 删除指针的重复元素值
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates (ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode root = new ListNode(-1);
        ListNode cur = head, p;
        stack.push(root.val);
        while (cur != null){
            if (cur.val != stack.peek()){
                p = cur;
                stack.push(p.val);
                cur = cur.next;
            }else {
                int s = stack.pop();
                while (cur != null && cur.val == s){
                    cur = cur.next;
                }
            }
        }
        root = null;
        while (!stack.isEmpty()){
            int s = stack.pop();
            ListNode node = new ListNode(s);
            node.next = null;
            if (root == null){
                root = node;
            }else {
                node.next = root;
                root = node;
            }
        }
        return root.next;
    }

    public static void show(ListNode head){
        ListNode cur = head;
        while (cur != null){
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
    }

}
