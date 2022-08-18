package com.leecode.algorithm.middle.sortArray;

import java.util.Arrays;

public class maxUncrossedLines {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] x = s.sortArray(new int[]{1,2,3,4,5,6,7,8,9});
        Arrays.stream(x).forEach(a->System.out.println(a));
        x = s.sortArray(new int[]{9,8,7,6,5,4,3,2,1});
        Arrays.stream(x).forEach(a->System.out.println(a));
        x = s.sortArray(new int[]{9,8,7,6,5,4,3,2,1,10,11,12,13,99,1,1,1,1});
        Arrays.stream(x).forEach(a->System.out.println(a));



    }
}
