package com.liu.day4;

import java.util.Stack;

/**
 * @author lms
 * @date 2021-08-19 - 21:03
 */
public class NC50 {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head1.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node = reverseKGroup(head1, 3);
        show(node);
    }


    /**
     *
     * 实现链表的反转操作
     * 给定的链表是1→2→3→4→5
     * 对于 k=2, 你应该返回  2→1→4→3→5
     * 对于 k=3, 你应该返回  3→2→1→4→5
     *
     * 解法：将一条链表分块分为链表长度/k块链表，如果处不尽则说明后面会有剩下的那一块是不满长度为k的。在最初的时候需要定义
     * 两个NodeList表示result(结果)和 now(当前所到达的结果链表的位置)。之后遍历块的长度，对每一个链表块进行翻转，再翻转
     * 完后将完成的链表插入到now链表的下一个，再将now链表更新到最前即可。
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup (ListNode head, int k) {
        ListNode phead = new ListNode(-1);
        ListNode p = phead, tmp;
        int count;
        Stack<ListNode> stack = new Stack<>();
        while (true){
            count = k;
            tmp = head;
            // 将前k个入栈
            while (count > 0 && tmp != null){
                stack.push(tmp);
                tmp = tmp.next;
                count--;
            }
            // 跳出上面循环，tmp是第k+1的元素
            // 如果循环结束，count不为0，则代表不足k个元素，就不进行翻转
            if (count > 0){
                p.next = head;
                break;
            }
            // 将入栈的前k个节点一次出栈，并使用尾插法
            while (!stack.isEmpty()){
                p.next = stack.pop();
                p = p.next;
            }
            // 仍然将当前出栈的链表和剩下的链表进行连接起来，
            // 将剩下的未入栈的序列作为一个新的链表重复前面的过程
            p.next = tmp;
            head = tmp;
        }
        return phead.next;
    }


    public static void show(ListNode head){
        ListNode cur = head;
        while (cur != null){
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
    }
}
