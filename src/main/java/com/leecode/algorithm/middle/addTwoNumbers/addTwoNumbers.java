package com.leecode.algorithm.middle.addTwoNumbers;

/**
 * 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class addTwoNumbers {

    public static void main(String[] args) {

        Solution s = new Solution();
        ListNode l111 = new ListNode(8);
        ListNode l11 = new ListNode(4,l111);
        ListNode l1 = new ListNode(7,l11);

        ListNode l222 = new ListNode(6);
        ListNode l22 = new ListNode(5,l222);
        ListNode l2 = new ListNode(9,l22);

        ListNode ln = s.addTwoNumbers(l1,l2);
        System.out.println("正确结果:1506");
        System.out.println("程序计算结果：" + ln.getValue(ln));

    }

}
