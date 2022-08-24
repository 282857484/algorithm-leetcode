package com.leecode.algorithm.middle.topKFrequent;


import java.util.*;

/**
 * 347. 前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 *
 *
 * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.topKFrequent(new int[]{1,1,1,2,2,3},2);
    }

    /**
     * 使用原生优先队列
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequentY(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();

            if (queue.size() == k) {
                // 如果优先队列满k个则与队尾比较，如果比队尾数量少
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                // 如果优先队列不满k个则直接往进扔kv
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }

    /**
     * 定制堆排序
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        Iterator<Map.Entry<Integer,Integer>> entry = map.entrySet().iterator();
        Map.Entry<Integer,Integer>[] e = new Map.Entry[map.size()];
        for (int i = 0; entry.hasNext(); i++) {
            e[i] = entry.next();
        }
        heapSort(e, k);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = e[e.length - 1 - i].getKey();
        }
        return result;
    }
    /**
     * 堆排序
     * @param array 用数组代表一颗完全二叉树
     * @return
     */
    public Map.Entry<Integer,Integer>[] heapSort(Map.Entry<Integer,Integer>[] array, int k) {
        // 找第一个根节点，就看最后一个叶子节点的根节点是谁
        int lastRoot =  array.length / 2 - 1;
        // 1、初始化堆
        for (int i = lastRoot; i >= 0; i--) {
            heapify(array, array.length, i);
        }
        // 2、对堆进行排序
        for (int i = array.length - 1; i >= (array.length - k); i--) {
            swap(array, i, 0);
            heapify(array, i, 0);
        }

        return array;
    }

    /**
     * （前提：之前对左右节点已经做过此操作）
     * 对以i为根节点的子树堆化
     * @param array 依托于数组的二叉树（二叉树构建堆）
     * @param n 以数组array[0:n]区间内进行堆化
     * @param i 对位置为i为根节点
     */
    public void heapify(Map.Entry<Integer,Integer>[] array, int n, int i) {
        if (i >= n) {
            return;
        }
        // 左节点
        int c1 = 2 * i + 1;
        // 右节点
        int c2 = 2 * i + 2;
        int max = i;
        if (c1 < n && array[max].getValue() < array[c1].getValue()) {
            max = c1;
        }
        if (c2 < n && array[max].getValue() < array[c2].getValue()) {
            max = c2;
        }
        if (i != max) {
            swap(array, i, max);
            // 交换的子节点需要对其重新堆化
            heapify(array, n, max);
        }
    }

    public void swap(Map.Entry[] nums, int i, int j) {
        Map.Entry temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
