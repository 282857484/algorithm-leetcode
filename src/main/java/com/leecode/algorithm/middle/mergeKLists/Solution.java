package com.leecode.algorithm.middle.mergeKLists;

import com.leecode.algorithm.node.CreateStruct;
import com.leecode.algorithm.node.ListNode;

/**
 * 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class Solution {
    public static void main(String[] args) {
        Solution s= new Solution();
        ListNode n = s.mergeKLists(new ListNode[]{
                CreateStruct.createListByArray(new int[]{2,3,4,5}),
                CreateStruct.createListByArray(new int[]{1,4,5}),
                CreateStruct.createListByArray(new int[]{1,2,3})
        });
        n.print();

    }

    public ListNode mergeKListsX(ListNode[] lists) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;

        while (judge(lists)){
            int pos = pick(lists);
            cur.next = lists[pos];
            cur = cur.next;
            lists[pos] = lists[pos].next;
        }
        cur.next = null;
        return pre.next;
    }

    private int pick(ListNode[] curList) {
        int min = Integer.MAX_VALUE;
        int pos = -1;
        for (int i = 0; i < curList.length; i++) {
            if (curList[i] != null) {
                if (curList[i].val < min) {
                    min = curList[i].val;
                    pos = i;
                }
            }
        }
        return pos;
    }

    private boolean judge(ListNode[] curList) {
        for (int i = 0; i < curList.length; i++) {
            if (curList[i] != null) {
                return true;
            }
        }
        return false;
    }



    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length<1)return null;
        return merge(lists,0,lists.length-1);
    }
    public ListNode merge(ListNode[] lists,int l,int r){
        if(l==r)return lists[l];
        int mid=(l+r)/2;
        ListNode l1=merge(lists,l,mid);
        ListNode l2=merge(lists,mid+1,r);
        return mergeTwoList(l1,l2);
    }
    public ListNode mergeTwoList(ListNode l1,ListNode l2){
        ListNode pre=new ListNode(0);
        ListNode cur=pre;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                cur.next=l1;
                l1=l1.next;
            }else{
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        cur.next=l1==null?l2:l1;
        return pre.next;
    }

}
