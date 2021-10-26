package com.leecode.algorithm.middle.maxArea;

class Solution {
    public static void main(String[] args) {
        Solution s= new Solution();
        System.out.println("结果:"+ s.maxArea(new int[]{3,9,3,5,6,9,3,4}));
    }
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;
        while(j > i) {
            int area = Math.min(height[i],height[j]) * (j - i);
            maxArea = Math.max(maxArea, area);
            // 双指针区间缩小，短板收缩才有可能比之前的大（长板收缩会变小）
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }
}