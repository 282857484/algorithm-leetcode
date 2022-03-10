package com.leecode.algorithm.node;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public String getValue(ListNode ln) {
        if (ln == null) {
            return "";
        }
        return getValue(ln.next)  + String.valueOf(ln.val);
    }

    public void print() {
        ListNode ss = this;
        while (ss != null) {
            System.out.println(ss.val);
            ss = ss.next;
        }
    }
}
