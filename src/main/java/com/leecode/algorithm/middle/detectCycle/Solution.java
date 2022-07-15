package com.leecode.algorithm.middle.detectCycle;

import com.leecode.algorithm.node.ListNode;

/**
 * 142. 环形链表 II
 * 给定一个链表的头节点 head，返回链表开始入环的第一个节点。如果链表无环，则返回null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改 链表。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    /**
     * 方法一： hashmap
     * 方法二：
     * lag出发，slow继续前行，他们的相遇点即环入口
     * a代表从开始到入环点距离
     * b代表入环点与相遇点距离
     * c代表相遇点到入环点距离
     * fast = slow * 2
     * fast = a + n(b+c) + b
     * slow = a + b
     * a = (n-1)(b+c) + c
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode lag = head;

        // 找到相遇点
        while (fast != null) {
            if (fast.next == null) {
                return null;
            } else if (fast.next.next == null) {
                return null;
            } else {
                fast = fast.next.next;
                slow = slow.next;
            }
            if (fast == slow) {
                break;
            }
        }

        while (lag != slow) {
            lag = lag.next;
            slow = slow.next;
        }

        return lag;
    }
}
