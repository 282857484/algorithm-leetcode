package com.leecode.algorithm.easy.reverseList;

import com.leecode.algorithm.node.CreateStruct;
import com.leecode.algorithm.node.ListNode;


class Solution {
    public static void main(String[] args) {
        CreateStruct c = new CreateStruct();
        ListNode n = c.createListByArray(new int[]{1,2,3,4,5,6,7,8});
        while (n != null) {
            System.out.print(n.val);
            n = n.next;
        }
        Solution s = new Solution();
        ListNode ss =  s.reverseList(n);
        while (ss != null) {
            System.out.println(ss.val);
            ss = ss.next;
        }
    }


    // 双指针 last、current
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