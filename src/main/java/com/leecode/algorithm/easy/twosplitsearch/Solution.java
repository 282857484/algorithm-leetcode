package com.leecode.algorithm.easy.twosplitsearch;

class Solution {
    public static void main(String[] args) {
        Solution s= new Solution();
        int x = s.search(new int[]{-1,0,3,5,9,12}, 2);
        System.out.println(x);
    }

    public int search(int[] nums, int target) {
        return findHalf(nums, 0, nums.length, target);
    }
    public int findHalf(int[] nums, int start_pos ,int end_pos, int target){
        int half = (start_pos + end_pos) / 2;
        if (half == 0) {
            if (nums[0] > target) {
                return -1;
            }
        }
        if (half == nums.length){
            return -1;
        }
        if (start_pos == end_pos) {
            return -1;
        }
        if (nums[half] == target) {
            return half;
        } else if (nums[half] > target)  {
            return findHalf(nums, start_pos, half, target);
        } else {
            return findHalf(nums, half + 1, end_pos, target);
        }
    }
}
