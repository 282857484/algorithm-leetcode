package com.leecode.algorithm.easy.search;

/**
 * 704. 二分查找
 * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1 {
    /**
     * 要点： 定义搜索区间 左闭右闭即[left, right]，或者左闭右开即[left, right)
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        // 区间左边界
        int left = 0;
        // 区间右边界
        int right = nums.length;
        // 构成搜索区间[left,right)
        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
}
