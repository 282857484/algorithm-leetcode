package com.leecode.algorithm.hard.reverseKGroup;

import com.leecode.algorithm.node.CreateStruct;
import com.leecode.algorithm.node.ListNode;


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
            ListNode nex = tail.next;
            // 翻转子链表并返回新子链表的头和尾
            ListNode[] reverse = reverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            // 把子链表重新接回原链表
            pre.next = head;
            tail.next = nex;
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