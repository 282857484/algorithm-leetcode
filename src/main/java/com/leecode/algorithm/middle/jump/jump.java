package com.leecode.algorithm.middle.jump;


public class jump {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{2,3,1,1,4,1,1,1,1,1,1,1,1};
//        int[] nums = new int[]{2,0,8,0,3,4,7,5,6,1,0,0,5,9,7,5,3,6};
        int result = s.jump(nums);
        System.out.println(result);
    }
}
