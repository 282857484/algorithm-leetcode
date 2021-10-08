package com.leecode.algorithm.hard.findMedianSortedArrays;

public class findMedianSortedArrays {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] m = new int[]{1,3};
        int[] n = new int[]{2};
        double result = s.findMedianSortedArrays(m,n);
        System.out.println("result: " + result);

    }
}
