package com.leecode.algorithm.easy.hasCycle;

import com.leecode.algorithm.node.CreateStruct;
import com.leecode.algorithm.node.ListNode;

public class Solution {
    public static void main(String[] args) {
        ListNode node = CreateStruct.createListByArray(new int[]{1});
        Solution s = new Solution();
        s.hasCycle(node);
    }
    public boolean hasCycle(ListNode head) {
        ListNode quick = head;
        ListNode slow = head;
        while (quick != null) {
             if (quick.next == null) {
                 return false;
             } else if (quick.next.next == null) {
                 return false;
             } else {
                 quick = quick.next.next;
                 slow = slow.next;
             }
            if (quick == slow) {
                return true;
            }
        }
        return false;
    }
}
