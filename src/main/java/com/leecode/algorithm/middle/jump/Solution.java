package com.leecode.algorithm.middle.jump;

/**
 * 跳跃游戏2
 * 贪心算法 1ms
 */
class Solution {
    public int jump(int[] nums) {
        int jumpNums= 0;
        int end = nums.length-1;
        for (int start = 0; start < end; ) {
            int step = nums[start];
            int reach = 0;
            int maxj = 0;
            for (int j = step; j > 0; j --) {
                if (start+ j >= nums.length-1){
                    maxj = j;
                    break;
                }
                if (nums[start + j] >0) {
                    if (reach < nums[start + j] +j){
                        reach = nums[start + j] +j;
                        maxj = j;
                    }
                }
            }
            start = start +maxj;
            jumpNums ++;
        }
        return jumpNums;
    }
}
