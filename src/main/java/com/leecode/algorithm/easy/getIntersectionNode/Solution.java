package com.leecode.algorithm.easy.getIntersectionNode;

import com.leecode.algorithm.node.ListNode;

/**
 * 面试题 02.07. 链表相交
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLen = 0;
        int bLen = 0;
        ListNode ha = headA;
        ListNode hb = headB;
        while (ha != null) {
            aLen++;
            ha = ha.next;
        }
        while (hb != null) {
            bLen++;
            hb = hb.next;
        }

        ha = headA;
        hb = headB;
        int diff = 0;
        if (aLen > bLen) {
            for (int i = 0; i < (aLen - bLen); i++) {
                ha = ha.next;
            }
            while (ha != null) {
                if (ha == hb) {
                    return ha;
                }
                ha = ha.next;
                hb = hb.next;
            }
        } else {
            for (int i = 0; i < (bLen - aLen); i++) {
                hb = hb.next;
            }
            while (ha != null) {
                if (ha == hb) {
                    return ha;
                }
                ha = ha.next;
                hb = hb.next;
            }
        }
        return null;
    }
}
