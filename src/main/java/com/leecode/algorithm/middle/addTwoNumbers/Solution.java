package com.leecode.algorithm.middle.addTwoNumbers;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0);
        ListNode lo = l;

        ListNode next1 = l1;
        ListNode next2 = l2;
        boolean inc = false;
        while (true) {
            int r = 0;
            if (next1 == null && next2 == null){
                if (inc) {
                    l.next = new ListNode(1);
                }
                break;
            }
            int nv1 = 0;
            int nv2 = 0;
            if (next1 != null) {
                nv1 = next1.val;
            }
            if (next2 != null) {
                nv2 = next2.val;
            }
            if (inc){
                r = nv1 + nv2 + 1;
            } else {
                r = nv1 + nv2;
            }
            if (r > 9) {
                inc = true;
                r = r % 10;
            } else {
                inc = false;
            }
            l.next = new ListNode(r);
            l = l.next;
            if (next1 != null) {
                next1 = next1.next;
            }
            if (next2 != null) {
                next2 = next2.next;
            }
        }
        return lo.next;

    }
}
