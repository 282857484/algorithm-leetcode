package com.leecode.algorithm.easy.moveZeroes;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {

            } else {
                nums[p1] = nums[i];
                p1++;
            }
        }
        for (int i = p1; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
