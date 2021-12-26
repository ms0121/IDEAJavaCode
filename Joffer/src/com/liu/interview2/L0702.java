package com.liu.interview2;

/**
 * @author lms
 * @date 2021-07-02 - 23:15
 */
public class L0702 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        ListNode l = ReverseList(listNode);
        print(l);

    }

    public static ListNode ReverseList(ListNode head) {
        ListNode pre = head;
        ListNode q = pre;
        head = null;
        while(pre != null){
            q = pre.next;
            pre.next = head;
            head = pre;
            pre = q;
        }
        return head;
    }

    public static void print(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
    }

}
