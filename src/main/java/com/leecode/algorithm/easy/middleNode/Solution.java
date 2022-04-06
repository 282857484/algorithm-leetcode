package com.leecode.algorithm.easy.middleNode;

import com.leecode.algorithm.node.ListNode;

import java.util.List;

/**
 *  876. 链表的中间结点
 *  给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode pre = new ListNode(0, head);
        ListNode quick = pre;
        ListNode slow = pre;
        while (true) {
            slow = slow.next;
            quick =quick.next;
            if (quick.next == null) {
                return slow;
            }
            quick =quick.next;
            if (quick.next == null) {
                return slow.next;
            }
        }
    }
}
