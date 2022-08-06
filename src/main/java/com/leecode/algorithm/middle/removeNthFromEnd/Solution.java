package com.leecode.algorithm.middle.removeNthFromEnd;


import com.leecode.algorithm.node.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        ListNode head = new ListNode(1);

        ListNode ln = s.removeNthFromEnd(head,1);
        while (ln != null) {
            System.out.print(ln.val + " ");
            ln = ln.next;
        }

    }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode noname = new ListNode(0,head);
        ListNode first = noname;
        ListNode second = noname;

        while (true) {
            if (first.next != null) {
                if (n > 0) {
                    first = first.next;
                    n--;
                } else if (n == 0) {
                    first = first.next;
                    second = second.next;
                }
            }else {
                if (n > 0){
                    // 还没走到头，不删节点
                } else {
                    second.next = second.next.next;
                }
                break;
            }
        }
        return noname.next;
    }
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode pre = head;
        ListNode post = head;
        ListNode postFront = new ListNode(0, head);
        ListNode ahead = postFront;
        for (int i = 0; i < n; i++) {
            pre = pre.next;
        }
        while (pre != null) {
            pre = pre.next;
            post = post.next;
            postFront = postFront.next;
        }
        postFront.next = post.next;
        return ahead.next;
    }


}