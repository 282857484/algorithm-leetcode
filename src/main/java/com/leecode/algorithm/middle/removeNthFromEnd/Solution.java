package com.leecode.algorithm.middle.removeNthFromEnd;


import com.leecode.algorithm.node.ListNode;

/**
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
//        ListNode l5 = new ListNode(5);
//        ListNode l4 = new ListNode(4,l5);
//        ListNode l3 = new ListNode(3,l4);
//        ListNode l2 = new ListNode(2,l3);
//        ListNode head = new ListNode(1,l2);

//        ListNode l2 = new ListNode(2);
//        ListNode head = new ListNode(1,l2);

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


//    public class ListNode {
//        int val;
//        ListNode next;
//        ListNode() {}
//        ListNode(int val) { this.val = val; }
//        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//    }

}