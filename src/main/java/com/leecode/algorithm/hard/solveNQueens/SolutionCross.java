package com.leecode.algorithm.hard.solveNQueens;

import java.util.ArrayList;
import java.util.List;

public class SolutionCross {
    public static void main(String[] args) {
        SolutionCross s = new SolutionCross();
        for (List l:
        s.solveNQueens(3)) {
            System.out.println(l);
        };
    }


    boolean[] select = null;
    String[] desc = null;
    List<List<String>> listlist = null;
    public List<List<String>> solveNQueens(int n) {
        listlist = new ArrayList<>(n);
        select = new boolean[n];
        desc = new String[n];
        nQueens(n);
        return listlist;
    }

    /**
     * ERROR
     * 错误：写成十字排列了
     * @param n
     */
    private void nQueens(int n) {
        if (n == 0) {
            List l = new ArrayList(select.length);
            for (int i = 0; i < desc.length; i++) {
                l.add(desc[i]);
            }
            listlist.add(l);
        }
        for (int i = 0; i < select.length; i++) {
            // 找到一个非true，标记、添加，再标记回来
            if (!select[i]){
                select[i] = true;
                StringBuilder s = new StringBuilder();
                for (int j = 0; j < select.length; j++) {
                    if (i==j) {
                        s.append('Q');
                    } else {
                        s.append('.');
                    }
                }
                desc[select.length-n] = s.toString();
                nQueens(n-1);
                select[i] = false;
            }
        }
    }
}
