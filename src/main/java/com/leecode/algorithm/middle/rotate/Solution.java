package com.leecode.algorithm.middle.rotate;

import java.util.Arrays;

/**
 * 189. 轮转数组
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] l = new int[]{1, 2, 3, 4};
        s.rotate(l, 2);
        Arrays.stream(l).forEach(x -> System.out.println(x));

        l = new int[]{1};
        s.rotate(l,1);
        Arrays.stream(l).forEach(x -> System.out.println(x));
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left ++;
            right --;
        }
    }

}