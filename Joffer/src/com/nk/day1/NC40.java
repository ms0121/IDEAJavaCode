package com.nk.day1;

import java.util.Stack;

/**
 * @author lms
 * @date 2021-09-13 - 8:56
 */
public class NC40 {
    public static void main(String[] args) {
        ListNode node = new ListNode(9);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(7);
        node.next = node1;
        node1.next = node2;

        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(3);
        node3.next = node4;

        ListNode node5 = addInList(node, node3);
        printRevers.traverse(node5);

    }

    // 两个链表相加
    public static ListNode addInList(ListNode head1, ListNode head2) {
        Stack<Integer> stack = getStack(head1);
        Stack<Integer> stack1 = getStack(head2);
        // 用于存放每个新生成的节点
        Stack<ListNode> stack2 = new Stack<>();
        // 记录进位数
        int carry = 0, sum;
        while (!stack.isEmpty() || !stack1.isEmpty() || carry != 0) {
            int x = 0, y = 0;
            if (!stack.isEmpty()) {
                x = stack.pop();
            }
            if (!stack1.isEmpty()) {
                y = stack1.pop();
            }
            // 计算对应位以及进位相加的结果
            sum = x + y + carry;
            // 将余数构成一个新的节点压入栈中
            ListNode node = new ListNode(sum % 10);
            stack2.push(node);
            // 取出余数部分
            carry = sum / 10;
        }
        head1 = null;
        ListNode cur = head1;
        // 使用尾插法，生成链表
        while (!stack2.isEmpty()){
            ListNode tmp = stack2.pop();
            if (head1 == null){
                head1 = tmp;
                cur = tmp;
            }else {
                cur.next = tmp;
                cur = tmp;
            }
        }
        return head1;
    }

    // 将链表的值压入栈中
    public static Stack<Integer> getStack(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        return stack;
    }
}
