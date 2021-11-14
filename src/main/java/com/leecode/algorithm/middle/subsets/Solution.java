package com.leecode.algorithm.middle.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s= new Solution();
        System.out.println("结果:");

         for (List<Integer> t : s.subsets(new int[]{1,2,3,4,5,6})) { System.out.println("结果:" + t);}
    }

    List<Integer> tmp = null;
    int[] nums = null;
    List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        tmp = new LinkedList<>();
        this.nums = nums;
        backtraceSets(0);
        return result;
    }

    private void backtraceSets(int i) {
        if (i == nums.length-1){
            result.add(new ArrayList<>(tmp));
            tmp.add(nums[nums.length-1]);
            result.add(new ArrayList<>(tmp));
            tmp.remove(tmp.size() - 1);
            return;
        }
        backtraceSets(i+1);
        tmp.add(nums[i]);
        backtraceSets(i+1);
        tmp.remove(tmp.size()-1);
    }
}