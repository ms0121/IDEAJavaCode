package com.liu.day3;

/**
 * @author lms
 * @date 2021-08-13 - 23:22
 */
public class NC70 {

    public static ListNode sortInList (ListNode head) {
        // write code here
        ListNode p = head, q;
        while (p != null){
            q = head;
            while (q != null && q.next != null){
                if (q.val > q.next.val){
                    int t = q.val;
                    q.val = q.next.val;
                    q.next.val = t;
                }
                q = q.next;
            }
            p = p.next;
        }
        return head;
    }
}
