package com.leecode.algorithm.middle.permutation;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution s= new Solution();
//        s.permutation("asdgzxcvewqqfsdfhrkjtuyk");
        String[] xx = s.permutation("asdfff");
        for (String x :
                xx) {
            System.out.println(x);
        }

    }
    // 因为每次操作都会复位，所以chars是唯一空间占用
    // 回溯法 空间复杂度降低
    char[] chars = null;
    // 存储最后结果集
    List<String> list = new LinkedList<>();
    public String[] permutation(String s) {
        chars = s.toCharArray();
        dps(0);
        return list.toArray(new String[list.size()]);
    }

    /**
     * 遍历第x层
     * @param x
     */
    private void dps(int x) {
        // 离开条件
        if (x == chars.length-1) {
            list.add(new String(chars));
            return;
        }
        // 第x层已经使用过的字符
        HashSet<Character> set = new HashSet<>();
        // 第x个位置可能出现的字符(只可能是chars[x]到chars[chars.length-1]中的某个字符)
        for (int i = x; i < chars.length; i ++) {
            // 第x层之前已经出现过这个字符
            // 对结果进行剪枝
            // 离开条件
            if (set.contains(chars[i])) {continue;}
            set.add(chars[i]);
            // 将第i位字符与第x位字符位置交换，下一层可能出现的结果就是chars[x+1]到chars[chars.length-1]中的某个字符
            // swap 解决了dps各层处理逻辑独立性
            // 做出选择
            swap(i, x);
            // 确定第x位字符之后，就可以遍历下一层
            // 子问题
            dps(x+1);
            // 操作完之后字符复位，进行后续的操作
            // 撤销选择
            swap(x, i);
        }
    }

    private void swap(int a, int b) {
        char tmp = chars[a];
        chars[a] = chars[b];
        chars[b] = tmp;
    }

}