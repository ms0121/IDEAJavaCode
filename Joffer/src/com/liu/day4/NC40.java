package com.liu.day4;

import java.util.LinkedList;

/**
 * @author lms
 * @date 2021-08-17 - 23:24
 */
public class NC40 {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(9);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(7);
        head1.next = node1;
        node1.next = node2;

        ListNode head2 = new ListNode(6);
        ListNode node3 = new ListNode(3);
        head2.next = node3;

        ListNode head = addInList(head1, head2);
        show(head);
    }

    /**
     * 使用栈的先进后出的方式进行计算链表的求和
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode addInList(ListNode head1, ListNode head2) {
        LinkedList<Integer> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();
        insertStack(stack1, head1);
        insertStack(stack2, head2);
        int carry = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int x = stack1.isEmpty() ? 0 : stack1.pop();
            int y = stack2.isEmpty() ? 0 : stack2.pop();

            int sum = x + y + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
        }
        return head;
    }

    /**
     * 将链表压入栈中
     *
     * @param stack
     */
    public static void insertStack(LinkedList<Integer> stack, ListNode head) {
        ListNode p = head;
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }
    }

    public static void show(ListNode head){
        ListNode cur = head;
        while (cur != null){
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
    }

}
