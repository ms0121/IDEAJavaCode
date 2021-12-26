package com.liu.day5;

/**
 * @author lms
 * @date 2021-08-28 - 21:47
 */
public class NC_69 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode root = FindKthToTail(node1, 5);
        show(root);
    }

    public static ListNode FindKthToTail (ListNode pHead, int k) {

        if (pHead == null || k > getLen(pHead)){
            return null;
        }
        ListNode p = pHead, cur = pHead;
        int i = 0;
        while (i < (k-1)){
            cur = cur.next;
            i++;
        }
        while (cur.next != null){
            p = p.next;
            cur = cur.next;
        }
        return p;
    }

    public static int getLen(ListNode pHead){
        ListNode cur = pHead;
        int count = 0;
        while (cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }

    public static void  show(ListNode pHead){
        while (pHead != null){
            System.out.print(pHead.val + " ");
            pHead = pHead.next;
        }
    }
}
