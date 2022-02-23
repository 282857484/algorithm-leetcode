package com.leecode.algorithm.middle.threeSum;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("结果:"+ s.threeSum(new int[]{-1,0,1,2,-1,-4}));
//        System.out.println("结果:"+ s.threeSum(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
        // for (T t : s.func()) { System.out.println("结果:" + t);}
    }

    // 双指针向内滑动
    // 优化的点就是去掉set，然后指针发现一样的值的时候快速移动
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        int len = nums.length;
        if (len < 3) {
            return lists;
        }
        Arrays.sort(nums);
        for (int a = 0; a < len - 2; a ++ ) {
            if (nums[a]> 0) {
                return lists;
            }
            int target = 0 - nums[a];
            int b = a + 1;
            int c = len - 1;
            // 因为是无重复的，所以上一个值一样的话就跳过
            if (a >0 && nums[a] == nums[a-1]) {
                continue;
            }
            while (c > b){
                if ((nums[b] + nums[c]) == target) {
                    List list = new ArrayList(3);
                    list.add(nums[a]);
                    list.add(nums[b]);
                    list.add(nums[c]);
                    lists.add(list);
                    // 因为是无重复的，所以值一样的话就跳过
                    while(c > b && nums[b] == nums[b + 1]) {
                        b++;
                    }
                    while(c > b && nums[c] == nums[c - 1]) {
                        c--;
                    }
                    c--;
                    b++;
                } else if ((nums[b] + nums[c]) > target){
                    c --;
                } else if ((nums[b] + nums[c]) < target){
                    b ++;
                }
            }
        }
        return lists;
    }
}
