package com.leecode.algorithm.middle.findKthLargest;

import java.util.Arrays;
import java.util.Random;

/**
 * 215. 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 *
 *
 * 提示：
 *
 * 1 <= k <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
public class Solution1 {
    /**
     * 优化快排可以将时间复杂度降低到时间复杂度O(n)
     * 优化方式：快排时每次选择某一个区间去除另一半区间的数据
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        return randomizedQuicksort(nums, 0, nums.length, k);
    }

    /**
     * 快排时根据k值选择区间
     * @param nums
     * @param l
     * @param r
     * @param k
     * @return
     */
    public int randomizedQuicksort(int[] nums, int l, int r, int k) {
        if (l < r) {
            int pos = randomizedPartition(nums, l, r);
            if (pos == k) {
                return nums[pos];
            } else if (k < pos) {
                return randomizedQuicksort(nums, l, pos - 1, k);
            } else  {
                return randomizedQuicksort(nums, pos + 1, r, k);
            }
        }
        return -1;
    }

    public int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l; // 区间内随机选一个作为我们的主轴
        swap(nums, r, i); // 交换到lr区间队尾
        return partition(nums, l, r);
    }

    /**
     * 返回中轴线的位置
     * @param nums
     * @param l
     * @param r
     * @return
     */
    public int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1; // 大小分界线
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
