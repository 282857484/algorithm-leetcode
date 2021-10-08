package com.leecode.algorithm.middle.lengthOfLIS;



public class lengthOfLIS {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        int result = s.lengthOfLIS(nums);
        System.out.println(result);
    }
}
