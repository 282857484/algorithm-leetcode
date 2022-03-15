package com.leecode.algorithm.middle.findKthLargest;

import java.util.Arrays;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-1-k];

    }
}
