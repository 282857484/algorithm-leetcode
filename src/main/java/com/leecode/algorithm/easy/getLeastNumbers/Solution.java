package com.leecode.algorithm.easy.getLeastNumbers;

/**
 * 剑指 Offer 40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 *
 * 限制：
 *
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 */
public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] result = new int[k];
        heapSort(arr, k);
        for (int i = 0; i < k; i++) {
            result[i] = arr[arr.length-1-i];
        }
        return result;
    }

    /**
     * 堆排序
     * 时间复杂度 nlog(k)
     * @param array 用数组代表一颗完全二叉树
     * @return
     */
    public int[] heapSort(int[] array, int k) {
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
     * 从小到大
     * @param array 依托于数组的二叉树（二叉树构建堆）
     * @param n 以数组array[0:n]区间内进行堆化
     * @param i 对位置为i为根节点
     */
    public void heapify(int[] array, int n, int i) {
        if (i >= n) {
            return;
        }
        // 左节点
        int c1 = 2 * i + 1;
        // 右节点
        int c2 = 2 * i + 2;
        int max = i;
        if (c1 < n && array[max] > array[c1]) {
            max = c1;
        }
        if (c2 < n && array[max] > array[c2]) {
            max = c2;
        }
        if (i != max) {
            swap(array, i, max);
            // 交换的子节点需要对其重新堆化
            heapify(array, n, max);
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
