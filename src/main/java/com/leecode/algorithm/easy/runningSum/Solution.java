package com.leecode.algorithm.easy.runningSum;

public class Solution {
    public int[] runningSum(int[] nums) {
        int sum = 0;
        int[] sums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sums[i] = sum + nums[i];
            sum = sums[i];
        }
        return sums;
    }
}
