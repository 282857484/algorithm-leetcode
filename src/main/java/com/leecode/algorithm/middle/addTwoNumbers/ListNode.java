package com.leecode.algorithm.middle.addTwoNumbers;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public String getValue(ListNode ln) {
        if (ln == null) {
            return "";
        }
        return getValue(ln.next)  + String.valueOf(ln.val);
    }
}
