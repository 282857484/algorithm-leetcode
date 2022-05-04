package com.leecode.algorithm.easy.reversePrint;

import com.leecode.algorithm.node.ListNode;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 */
public class Solution {
    public int[] reversePrint(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len ++;

            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        ListNode h = pre;
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = h.val;
            h = h.next;
        }
        return array;

    }
}
