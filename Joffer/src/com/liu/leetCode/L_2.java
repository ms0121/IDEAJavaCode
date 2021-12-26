package com.liu.leetCode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/**
 * @author lms
 * @date 2021-08-22 - 20:44
 */
public class L_2 {
    public static void main(String[] args) {
        ListNode root = new ListNode(2);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        root.next = node1;
        node1.next = node2;

        ListNode root2 = new ListNode(5);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(4);
        root2.next = node3;
        node3.next = node4;

        ListNode root1 = sum(root, root2);
        show(root1);

    }


    public static ListNode sum(ListNode l1, ListNode l2){
        Queue<Integer> queue1 = getQueue(l1);
        Queue<Integer> queue2 = getQueue(l2);
        int carry = 0;
        l1 = null;
        Stack<ListNode> stack = new Stack<>();
        while (!queue1.isEmpty() || !queue2.isEmpty() || carry != 0){
            int x = queue1.poll();
            int y = queue2.poll();
            int s = x + y + carry;
            ListNode node = new ListNode(s % 10);
            stack.push(node);
            carry = s / 10;
        }
        while (!stack.isEmpty()){
            ListNode node = stack.pop();
            node.next = l1;
            l1 = node;
        }
        return l1;
    }


    public static Queue<Integer> getQueue(ListNode root){
        Queue<Integer> queue = new LinkedList<>();
        while (root != null){
            queue.offer(root.val);
            root = root.next;
        }
        return queue;
    }

    public static void show(ListNode root){
        if (root == null){
            return;
        }
        System.out.print(root.val + " -> ");
        show(root.next);
    }

}
