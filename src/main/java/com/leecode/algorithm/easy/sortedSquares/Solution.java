package com.leecode.algorithm.easy.sortedSquares;

public class Solution {
    /**
     * 977.有序数组的平方
     *
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int r = 0;

        int absMin = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            int abs = Math.abs(nums[i]);
            if (absMin > abs) {
                absMin = abs;
                left = i;
                right = i;
            }
        }
        while (left > -1 || right < nums.length) {
            if (left == right) {
                result[r] = nums[left] * nums[left];
                r++;
                left--;
                right++;
                continue;
            }
            if (left == -1) {
                result[r] = nums[right] * nums[right];
                r++;
                right++;
                continue;
            }
            if (right == nums.length) {
                result[r] = nums[left] * nums[left];
                r++;
                left--;
                continue;
            }
            int absLeft = Math.abs(nums[left]);
            if (absLeft < nums[right]) {
                result[r] = nums[left] * nums[left];
                r++;
                left--;
                continue;
            } else {
                result[r] = nums[right] * nums[right];
                r++;
                right++;
                continue;
            }
        }
        return result;
    }
}
