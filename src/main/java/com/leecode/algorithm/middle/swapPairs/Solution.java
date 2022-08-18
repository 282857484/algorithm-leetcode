package com.leecode.algorithm.middle.swapPairs;

import com.leecode.algorithm.node.ListNode;

/**
 * 24. 两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 *
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1]
 * 输出：[1]
 *
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode ahead = new ListNode(0, head);
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode pre = ahead;
        ListNode cur = head;
        ListNode curn = head.next;
        ListNode post = head.next.next;

        while (cur != null && curn != null) {
            curn.next = cur;
            cur.next = post;
            pre.next = curn;
            if (post == null) {
                break;
            }
            if (post.next == null) {
                break;
            }
            pre = cur;
            cur = post;
            curn = cur.next;
            post = curn.next;
        }
        return ahead.next;
    }
}
