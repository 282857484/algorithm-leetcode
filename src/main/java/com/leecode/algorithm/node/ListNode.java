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

    /**
     * 反转链表
     * @param head 头指针
     * @param tail 尾指针
     * @return 新的头和尾指针
     */
    public ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }
}
