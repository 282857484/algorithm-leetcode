package com.leecode.algorithm.hard.firstMissingPositive;

class Solution {
    public static void main(String[] args) {
        Solution s= new Solution();
        System.out.println("结果:"+s.firstMissingPositive(new int[]{1}));
    }

    public int firstMissingPositive(int[] nums) {
        int[] array = new int[nums.length + 2];
        for (int i : nums) {
            if (i < (nums.length + 1) && i > 0) {
                array[i] = 1;
            }
        }
        for (int i = 1; i < array.length; i++) {
            if (array[i] == 0) {
                return i;
            }
        }
        return -1;
    }

}