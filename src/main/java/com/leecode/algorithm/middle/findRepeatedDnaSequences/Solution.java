package com.leecode.algorithm.middle.findRepeatedDnaSequences;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT")
                .stream().forEach(x -> System.out.println(x));


    }

    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> result = new HashSet();
        if (s.length()< 10) {
            return result.stream().collect(Collectors.toList());
        }
        int mo = (1 << 20) -1;

        char[] seq = s.toCharArray();
        Set<Integer> set = new HashSet<>();
        int num = 0;
        for (int i = 0; i < 9; i++) {
            num = num << 2 | trans(seq[i]);
        }
        for (int i = 9; i < s.length(); i++) {
            num = num << 2 & mo | trans(seq[i]);
            if (set.contains(num)) {
                result.add(s.substring(i-9,i+1));
            } else {
                set.add(num);
            }
        }
        return result.stream().collect(Collectors.toList());
    }
    private int trans(char x) {
        switch (x) {
            case 'A':
            return 0;
            case 'C':
            return 1;
            case 'G':
            return 2;
            case 'T':
            return 3;
        }
        return 0;
    }
}
