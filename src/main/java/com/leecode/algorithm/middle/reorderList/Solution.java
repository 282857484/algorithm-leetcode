package com.leecode.algorithm.middle.reorderList;

import com.leecode.algorithm.node.CreateStruct;
import com.leecode.algorithm.node.ListNode;

import java.util.List;

/**
 * 143. 重排链表
 *
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode n = CreateStruct.createListByArray(new int[]{1,2,3,4});
        s.reorderList(n);
    }

    /**
     * 第一种思路：将链表转为数组，然后再操作
     * 第二种思路：找到中位节点，翻转后半部分链表，然后再重组
     * @param head
     */
    public void reorderList(ListNode head) {
        ListNode midpre = middleNode(head);
        ListNode rev = reverseList(midpre.next);
        midpre.next = null;
        ListNode n1 = head;
        ListNode n2 = rev;
        while (n2 != null) {
            ListNode tmp1 = n1.next;
            ListNode tmp2 = n2.next;
            n1.next = n2;
            n1 = tmp1;
            n2.next = tmp1;
            n2 = tmp2;
        }
    }

    public ListNode middleNode(ListNode head) {
        ListNode pre = new ListNode(0, head);
        ListNode quick = pre;
        ListNode slow = pre;
        while (true) {
            quick =quick.next;
            if (quick.next == null) {
                return slow;
            }
            quick =quick.next;
            if (quick.next == null) {
                return slow.next;
            }
            slow = slow.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode last = null;
        ListNode current = head;
        while (current != null) {
            ListNode tmp = current.next;
            current.next = last;
            last = current;
            current = tmp;
        }
        return last;
    }
}
