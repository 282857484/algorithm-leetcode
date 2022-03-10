package com.leecode.algorithm.easy.mergeTwoLists;

import com.leecode.algorithm.node.CreateStruct;
import com.leecode.algorithm.node.ListNode;

/**
 * java中的对象都是
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
class Solution {
    public static void main(String[] agrs) {
        Solution s= new Solution();
        s.mergeTwoLists(CreateStruct.createListByArray(new int[]{1,2,4}),CreateStruct.createListByArray(new int[]{1,3,4}))
        .print();
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (!(p1 == null && p2 == null)) {
            if (p1 == null) {
                cur.next = p2;
                break;
            } else if (p2 == null) {
                cur.next = p1;
                break;
            } else if (p1.val > p2.val) {
                cur.next = p2;
                cur = p2;
                p2 = p2.next;
            } else {
                cur.next = p1;
                cur = p1;
                p1 = p1.next;
            }
        }
        return head.next;
    }
}