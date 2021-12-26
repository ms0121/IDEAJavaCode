package com.liu.interview2;

import com.sun.jndi.ldap.Ber;
import sun.util.locale.provider.FallbackLocaleProviderAdapter;

import java.util.ArrayList;
import java.util.Queue;

/**
 * @author lms
 * @date 2021-04-10 - 22:19
 */
public class L_02_06 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
//        ListNode listNode2 = new ListNode(2);
//        ListNode listNode3 = new ListNode(1);
        listNode.next = listNode1;
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
        boolean palindrome1 = isPalindrome1(listNode);
        System.out.println("palindrome1 = " + palindrome1);
    }


    public static boolean isPalindrome1(ListNode head) {
        ListNode cur = head;
        ArrayList<Integer> list = new ArrayList<>();

        while (cur != null){
            list.add(0, cur.val);
            cur = cur.next;
        }

        boolean flag = true;
        while (head != null){
            if (!(head.val == list.get(0))){
                flag = false;
                break;
            }
            head = head.next;
            list.remove(0);
        }
        return flag;
    }

    // 判断当前的链表是否是回文序列的链表
    // 1. 先找到链表的中间节点，然后将链表的后半部分进行反转
    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && slow != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // 判断链表节点的奇偶数
        if (fast != null){
            slow = slow.next;
        }

        // 将链表的后半部分进行反转的操作
        ListNode second = reserve(slow);


        return true;
    }

    private static ListNode reserve(ListNode slow) {
        ListNode head = null,cur = slow;
        while (cur.next != null){
            cur = slow.next;
            slow.next = head;
        }
        return head;
    }
}
