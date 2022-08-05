package com.leecode.algorithm.middle.search;

import java.util.Arrays;

/**
 * 33. 搜索旋转排序数组
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（
 * 下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为[4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，
 * 则返回它的下标，否则返回-1。
 */
public class Solution1 {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        s.search(new int[]{4,5,6,7,0,1,2},0);
    }

    /**
     * 要点：加入辅助工具后哪些是确定的事情
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int edge = nums[nums.length-1];
        if (edge == target) {
            return nums.length-1;
        }
        while (left < right){
            int m = (left + right) / 2;
            int middle = nums[m];
            if (target == middle) {
                return m;
            }
            // 根据middle与edge能确定的事情是有一边是有序的，然后根据有序的那一边是否是target的范围
            if (middle > edge) {
                // m左边有序
                if (target >= nums[left] && target < middle){
                    right = m;
                } else {
                    left = m+1;
                }
            } else {
                // m右边有序
                if (target <= nums[right-1] && target > middle) {
                    left = m+1;
                } else {
                    right = m;
                }
            }
        }
        return -1;
    }


}
