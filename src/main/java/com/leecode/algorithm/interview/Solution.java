package com.leecode.algorithm.interview;

import com.leecode.algorithm.node.ListNode;

/**
 * 测试结构对象
 * 1在类内声明需要static
 * 2在类外声明不需要static
 * 3引用外部
 */
public class Solution {

    public static void main(String[] args) {
        // Scanner input=new Scanner(System.in);
        // String str=input.next();
        ListNode a3 = new ListNode(3);
        ListNode a2 = new ListNode(2, a3);
        ListNode a1 = new ListNode(1, a2);
        Solution m = new Solution();
        ListNode n = m.reverseList(a1);
        while (n != null) {
        }
        System.out.println("hello world");
    }

//    /**
//     * 写到内部类需要静态
//     */
//    static class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode() {
//        }
//
//        ListNode(int val) {
//            this.val = val;
//        }
//
//        ListNode(int val, ListNode next) {
//            this.val = val;
//            this.next = next;
//        }
//    }

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

/**
 * 写到外部不需要静态
 */
//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode() {
//    }
//
//    ListNode(int val) {
//        this.val = val;
//    }
//
//    ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//}
