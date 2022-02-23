package com.leecode.algorithm.easy.containsDuplicate;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer num: nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
