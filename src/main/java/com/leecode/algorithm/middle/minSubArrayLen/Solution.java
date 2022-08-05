package com.leecode.algorithm.middle.minSubArrayLen;

public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        // 区间是左开右闭
        int left = 0;
        int right = 0;
        int sum = 0;
        while (left != nums.length) {
            if (sum < target){
                if (right < nums.length) {
                    sum += nums[right];
                    right++;
                } else {
                    break;
                }
            } else {
                minLen = Math.min(minLen, right-left);
                sum -= nums[left];
                left ++;
            }
        }
        if (minLen == Integer.MAX_VALUE) {
            return 0;
        }else {
            return minLen;
        }
    }
}
