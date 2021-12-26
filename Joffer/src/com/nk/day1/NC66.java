package com.nk.day1;

import java.util.HashMap;

/**
 * @author lms
 * @date 2021-09-13 - 8:39
 */
public class NC66 {
    public static void main(String[] args) {

    }

    // 计算两个单链表第一个公共节点
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2){
        HashMap<ListNode, ListNode> hashMap = new HashMap<>();
        // 将链表1全部设置到哈希表中
        while (pHead1 != null){
            if (!hashMap.containsKey(pHead1)){
                hashMap.put(pHead1, pHead1);
                pHead1 = pHead1.next;
            }
        }

        // 查询第二个链表中的节点是否存在hashMap中
        while (pHead2 != null){
            if (hashMap.containsKey(pHead2)){
                return pHead2;
            }else {
                pHead2 = pHead2.next;
            }
        }
        return null;
    }
}
