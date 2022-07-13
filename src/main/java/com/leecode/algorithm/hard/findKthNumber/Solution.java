package com.leecode.algorithm.hard.findKthNumber;

import com.leecode.algorithm.node.TreeNode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 440. 字典序的第K小数字
 * 给定整数 n 和 k，返回  [1, n] 中字典序第 k 小的数字。
 *
 * 输入: n = 13, k = 2
 * 输出: 10
 * 解释: 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
 *
 */
public class Solution {
    /**
     * 第k小数字可以理解为字典顺序的位置
     *
     * 字典树前序遍历可以暴力求解
     * 因为n值可能很大，所以不能按树的前序遍历
     * 关键问题
     * 1.如何快速计数：统计以x为前缀的子树，[1:limit]为限定量范围的节点数
     * 2.如何移动到最终结果：
     *   a、向下移一位结果值+1
     *   b、向左移一位结果值+左边树上的全部值
     *
     * @param n
     * @param k
     * @return
     */
    public int findKthNumber(int n, int k) {
        int ans = 1;
        while (k > 1) {
            int cnt = getCnt(ans, n);
            if (cnt <= k) {
                k -= cnt;
                ans++;
            } else {
                k--;
                ans *= 10;
            }
        }
        return ans;
    }

    /**
     * 当前子节点下有多少子节点（不包含本身）
     * 每一层的数量是这一层的结尾(last)减去开始(first)加1
     * 即last - first + 1
     * 最后一层的数量如果不是满的话，limit肯定与这一层第一个元素是同一个数量级
     * 所以取其最小值
     * @param curr
     * @param limit
     * @return
     */
    public int getCnt(int curr, long limit) {
        int totalNodeNum = 0;
        long first = curr;
        long last = curr;
        while (first <= limit) {
            totalNodeNum += Math.min(last, limit) - first + 1;
            first = first * 10;
            last = last * 10 + 9;
        }
        return totalNodeNum;
    }
}
