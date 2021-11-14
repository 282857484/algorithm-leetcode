package com.leecode.algorithm.middle.grayCode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s= new Solution();
        System.out.println("结果:"+ s.grayCode(5));

        // for (T t : s.func()) { System.out.println("结果:" + t);}
    }
    ArrayList<Integer> result = null;
    int head = 1;
    public List<Integer> grayCode(int n) {
        result = new ArrayList<>();
        result.add(0);
        for (int i = 0; i < n; i++) {
            addGrayCode(i);
        }
        return result;
    }

    private void addGrayCode(int i) {
        for (int j = result.size()-1; j >= 0; j--) {
            result.add(result.get(j) + head);
        }
        head = head << 1;
    }
}