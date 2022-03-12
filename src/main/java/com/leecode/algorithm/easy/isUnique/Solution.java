package com.leecode.algorithm.easy.isUnique;

class Solution {
    public boolean isUnique(String astr) {
        int mark = 0;
        for (char x: astr.toCharArray()) {
            if ((mark & 1 << (x-'a')) != 0) {
                return false;
            } else {
                mark = mark | 1 << (x-'a');
            }
        }
        return true;
    }
}