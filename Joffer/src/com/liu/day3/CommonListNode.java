package com.liu.day3;

/**
 * @author lms
 * @date 2021-07-05 - 13:51
 */
public class CommonListNode {

    public static int getLength(ListNode head){
        int i = 0;
        ListNode p = head;
        while (p != null){
            i++;
            p = p.next;
        }
        return i;
    }


    public static void traverse(ListNode head){
        ListNode p = head;
        while (p != null){
            System.out.print(p.val + "--> ");
            p = p.next;
        }
        System.out.println();
    }

}
