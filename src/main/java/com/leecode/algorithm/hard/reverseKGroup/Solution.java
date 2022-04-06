package com.leecode.algorithm.hard.reverseKGroup;

import com.leecode.algorithm.node.CreateStruct;
import com.leecode.algorithm.node.ListNode;

/**
 * 25. K 个一组翻转链表
 * 给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
 * k是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 进阶：
 *
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */

class Solution {
    public static void main(String[] args) {
        CreateStruct c = new CreateStruct();
        ListNode n = c.createListByArray(new int[]{1,2,3,4,5,6,7,8});
//        while (n != null) {
//            System.out.println(n.val);
//            n = n.next;
//        }
        Solution s = new Solution();
        ListNode ss =  s.reverseKGroup(n,2);
        while (ss != null) {
            System.out.println(ss.val);
            ss = ss.next;
        }
    }



    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;

        while (head != null) {
            ListNode tail = pre;
            // 向右移动tail指针k个位置
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                // 如果长度不够的话则返回
                if (tail == null) {
                    return hair.next;
                }
            }
            // 保存tail.next
            ListNode tmp = tail.next;
            // 翻转子链表并返回新子链表的头和尾
            ListNode[] reverse = reverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            // 把子链表重新接回原链表
            pre.next = head;
            tail.next = tmp;
            pre = tail;
            head = tail.next;
        }

        return hair.next;
    }

    /**
     *
     * @param head
     * @param tail
     * @return
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