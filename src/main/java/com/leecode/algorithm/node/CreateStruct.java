package com.leecode.algorithm.node;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class CreateStruct {
    public static void main(String[] args) {
        CreateStruct c = new CreateStruct();
        ListNode n = c.createListByArray(new int[]{1,2,3,4,5,6,7,8});
        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }

        TreeNode tree = c.createTreeByArray(new int[]{1,2,3,4,5,6,7,8});

        // 前序遍历
        c.frontVisitor(tree);
        // 倒序遍历
        c.reverseVisitor(tree);

        c.reverseVisitorX(tree);

    }

    /**
     * 打印每一层节点，先
     * @param tree
     */
    private void reverseVisitorX(TreeNode tree) {

        int cur = 0;
        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(tree);
        while (cur < list.size()) {
            if (list.get(cur).left != null) {
                list.add(list.get(cur).left);
            }
            if (list.get(cur).right != null) {
                list.add(list.get(cur).right);
            }
            cur ++;
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i).val);
        }
    }
    private void reverseVisitor(TreeNode tree) {
        // 前序遍历
//        System.out.println(tree.val);
        if (tree.left != null) {
            reverseVisitorX(tree.left);
        }
        // 中序遍历
//        System.out.println(tree.val);
        if (tree.right != null) {
            reverseVisitorX(tree.right);
        }
        // 后序遍历
        System.out.println(tree.val);
    }

    /**
     * 树的前序遍历
     *
     * @param tree
     */
    private void frontVisitor(TreeNode tree) {
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(tree);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            System.out.println(treeNode.val);
            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }
    }

    /**
     *
     * @param nums
     * @return
     */
    public static ListNode createListByArray(int[] nums) {
        ListNode last = new ListNode();
        ListNode first = new ListNode(0, last);

        for (int i = 0; i < nums.length; i++) {
            ListNode cur = new ListNode(nums[i], null);
            last.next = cur;
            last = cur;
        }
        return first.next.next;
    }


    /**
     * 二叉树 [i]位置左节点[2i+1],右节点[2i+2]
     * @param nums
     * @return
     */
    public static TreeNode createTreeByArray(int[] nums) {
        TreeNode root = new TreeNode(nums[0], null, null);
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();

        int cnt = 0;
        TreeNode cur = root;
        for (int i = 1; i < nums.length; i++) {
            if (cnt == 2) {
                cur = queue.poll();
                cnt = 0;
            }
            // int数据没有空元素
            TreeNode node = new TreeNode(nums[i]);
            if (cnt == 0) {
                cur.left = node;
            } else if (cnt == 1) {
                cur.right = node;
            }
            cnt ++;
            queue.offer(node);
        }
        return root;
    }

    /**
     * 将一段链表翻转
     * 双指针 last、current
     * @param head
     * @param tail
     * @return 新的链表头和尾
     */
    public ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }
}
