package com.nk.day2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author lms
 * @date 2021-09-19 - 12:52
 */
public class NC2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(2);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        head.next = node;
        node.next = node1;
        node1.next = node2;
//        node2.next = node3;
//        reorderList(head);


    }

    public static void reorderList(ListNode head) {
        if (head == null){
            return;
        }
        int len = length(head);
        if (len == 1){
            return;
        }
        int i = 0;
        ListNode head2 = head, cur = head,root = null;
        while (i < (len / 2)){
            head2 = head2.next;
            i++;
        }
        if (len % 2 != 0){
            head2 = head2.next;
        }
        while (cur.next != head2){
            cur = cur.next;
        }
        cur.next = null;

//        System.out.println(head2.val);
        // 将head2拼接在head后面
        // 先将head压入队列，head2压入栈中
        Queue<ListNode> queue = getQueue(head);
        Stack<ListNode> stack = getStack(head2);
        cur = null;
        while (!queue.isEmpty() && !stack.isEmpty()){
            ListNode queueNode = queue.poll();
            ListNode stackNode = stack.pop();
            if (root == null){
                root = queueNode;
                cur = queueNode;
                cur.next = stackNode;
                cur = stackNode;
            }else {
                cur.next = queueNode;
                cur = queueNode;
                cur.next = stackNode;
                cur = stackNode;
            }
        }
        while (!queue.isEmpty()){
            ListNode poll = queue.poll();
            cur.next = poll;
            cur = poll;
        }
        cur.next = null;
    }

    public static Queue<ListNode> getQueue(ListNode head){
        Queue<ListNode> queue = new LinkedList<>();
        while (head != null){
            queue.add(head);
            head = head.next;
        }
        return queue;
    }


    public static Stack<ListNode> getStack(ListNode head){
        Stack<ListNode> stack = new Stack<>();
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        return stack;
    }


    public static int length(ListNode head){
        ListNode cur = head;
        int count = 0;
        while (cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }
}
