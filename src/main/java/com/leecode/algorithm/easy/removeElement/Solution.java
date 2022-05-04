package com.leecode.algorithm.easy.removeElement;

/**
 * 27. 移除元素
 * 双指针法（快慢指针法）： 通过一个快指针和慢指针在一个for循环下完成两个for循环的工作
 */
public class Solution {
    public static void main(String[] agrs) {
        Solution s = new Solution();
        s.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2);
    }
    public int removeElement(int[] nums, int val) {
        int slowIndex = 0;
        for (int quickIndex = 0; quickIndex < nums.length; quickIndex++) {
            if (nums[quickIndex] != val) {
                nums[slowIndex] = nums[quickIndex];
                slowIndex ++;
            }
        }
        return slowIndex;
    }
}
