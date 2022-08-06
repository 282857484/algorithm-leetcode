package com.leecode.algorithm.easy.removeElements;

import com.leecode.algorithm.node.ListNode;


public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode preHeader = new ListNode(0, head);
        ListNode pre = preHeader;
        ListNode current = head;
        while (current != null) {
            if (current.val == val) {
                pre.next = current.next;
                current = current.next;
            } else {
                current = current.next;
                pre = pre.next;
            }
        }
        return preHeader.next;
    }
}
