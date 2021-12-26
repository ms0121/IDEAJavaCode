package com.liu.interview2;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * @author lms
 * @date 2021-04-10 - 17:18
 */
public class L_02_05 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(7);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(6);
        listNode.next = listNode1;
        listNode1.next = listNode2;

        ListNode listNode3 = new ListNode(5);
        ListNode listNode4 = new ListNode(9);
        ListNode listNode5 = new ListNode(2);
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode listNode6 = addTwoNumbers(listNode, listNode3);
        print(listNode6);

    }

    //    输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
    //    输出：2 -> 1 -> 9，即912
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int tmp = 0;
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while ((l1 != null) || (l2 != null) || (tmp != 0)) {
            if (l1 != null) {
                tmp += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                tmp += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(tmp % 10);
            cur = cur.next;
            tmp = tmp / 10;
        }
        return res.next;
    }

    public static void print(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
    }
}





