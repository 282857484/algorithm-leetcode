package com.leecode.algorithm.middle.permute;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> x  = s.permute(new int[]{1,2,3});
        System.out.println(x);
    }

    public List<List<Integer>> permute(int[] nums) {
        LinkedList current = new LinkedList();
        LinkedList<Integer> numlist = new LinkedList();
        for (int x: nums) {
            numlist.add(x);
        }
        return myfun(current,numlist);
    }

    public List<List<Integer>> myfun(LinkedList current, LinkedList<Integer> num) {
        List<List<Integer>> xxx = new LinkedList<>();
        for (int i = 0; i < num.size(); i++) {
            LinkedList newcurrent = (LinkedList) current.clone();
            newcurrent.add(num.get(i));
            LinkedList<Integer> xx = (LinkedList<Integer>) num.clone();
            xx.remove(i);
            if (xx.size() != 0) {
                xxx.addAll(myfun(newcurrent, xx));
            } else {
                xxx.add(newcurrent);
            }
        }
        return xxx;
    }
}