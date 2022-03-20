package com.leecode.algorithm.hard.solveNQueens;

import java.util.ArrayList;
import java.util.List;

/**
 * n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。
 * 每一种解法包含一个不同的n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 */

/**
 * 皇后可以横着走、竖着走、斜着走
 * 回溯算法
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<String>> ss = s.solveNQueens(4);
        System.out.println(ss);
    }

    int len = 0;
    // 0-unmark 1-choice 2-attack
    private int[][] mark = null;
    List<List<String>> lists = null;
    public List<List<String>> solveNQueens(int n) {
        this.len = n;
        mark = new int[n][n];
        lists = new ArrayList<>();
        nQueen(n-1);
        return lists;
    }
    // 处理第n层
    private void nQueen(int n) {
        for (int i = 0; i < len; i++) {
            // check i, n是否可选
            // 检查i,n方向
            if (check(i,n)) {
                // 如果可选则标记并处理nQueen(n-1)
                mark(i,n,false);
                if (n != 0) {
                    nQueen(n - 1);
                } else {
                    // 最后一层也可以找到的话将数组记录到结果集中
                    save();
                }

                // 复位
                mark(i,n,true);
            }
        }
    }

    private void save() {
        List<String> list = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < len; j++) {
                if (mark[i][j] == 1) {
                    s.append('Q');
                } else {
                    s.append('.');
                }
            }
            list.add(s.toString());
        }
        lists.add(list);
    }

    private void markX(int m, int n, boolean reset) {
        int val = 0;
        if (reset){
//            mark[n][m] = 0;
            val = -2;
        } else {
//            mark[n][m] = 1;
            val = 2;
        }

        for (int j = 0; j < len; j++) {
            if (n == j && m == j) {

            }
            mark[n][j] += val;
            mark[j][m] += val;
        }
        int i = 0;
        int j = 0;

        i = m;
        j = n;
        i--;
        j--;
        while (i >=0 && j >=0 && i < len && j < len) {
            mark[j][i] += val;
            i--;
            j--;
        }

        i = m;
        j = n;
        i++;
        j--;
        while (i >=0 && j >=0 && i < len && j < len) {
            mark[j][i] += val;
            i++;
            j--;
        }

        i = m;
        j = n;
        i++;
        j++;
        while (i >=0 && j >=0 && i < len && j < len) {
            mark[j][i] += val;
            i++;
            j++;
        }

        i = m;
        j = n;
        i--;
        j++;
        while (i >=0 && j >=0 && i < len && j < len) {
            mark[j][i] += val;
            i--;
            j++;
        }

        if (reset){
            mark[n][m] = 0;
        } else {
            mark[n][m] = 1;
        }
    }
    //小优化，没有提速。。。
    private void mark(int m, int n, boolean reset) {
        int val = 0;
        if (reset) {
//            mark[n][m] = 0;
            val = -2;
        } else {
//            mark[n][m] = 1;
            val = 2;
        }

        for (int j = 0; j < len; j++) {
            if (n == j && m == j) {

            }
            mark[n][j] += val;
            mark[j][m] += val;
        }
        int i = 0;
        int j = 0;

        i = m;
        j = n;
        i--;
        j--;
        while (i >= 0 && j >= 0) {
            mark[j][i] += val;
            i--;
            j--;
        }

        i = m;
        j = n;
        i++;
        j--;
        while (j >= 0 && i < len) {
            mark[j][i] += val;
            i++;
            j--;
        }

        i = m;
        j = n;
        i++;
        j++;
        while (i < len && j < len) {
            mark[j][i] += val;
            i++;
            j++;
        }

        i = m;
        j = n;
        i--;
        j++;
        while (i >= 0 && j < len) {
            mark[j][i] += val;
            i--;
            j++;
        }

        if (reset) {
            mark[n][m] = 0;
        } else {
            mark[n][m] = 1;
        }
    }

    private boolean check(int m, int n) {
        if (mark[n][m] > 1) {
            return false;
        } else {
            return true;
        }
    }

//    private boolean check(int m, int n) {
//        for (int j = 0; j < len; j++) {
//            if (mark[n][j] == 2 || mark[j][m] == 2) {
//                return false;
//            }
//        }
//        int i = 0;
//        int j = 0;
//
//        i = m;
//        j = n;
//        i--;
//        j--;
//        while (i >=0 && j >=0 && i < len && j < len) {
//            if (mark[j][i] == 2) {
//                return false;
//            }
//            i--;
//            j--;
//        }
//
//        i = m;
//        j = n;
//        i++;
//        j--;
//        while (i >=0 && j >=0 && i < len && j < len) {
//            if (mark[j][i] == 2) {
//                return false;
//            }
//            i++;
//            j--;
//        }
//
//        i = m;
//        j = n;
//        i++;
//        j++;
//        while (i >=0 && j >=0 && i < len && j < len) {
//            if (mark[j][i] == 2) {
//                return false;
//            }
//            i++;
//            j++;
//        }
//
//        i = m;
//        j = n;
//        i--;
//        j++;
//        while (i >=0 && j >=0 && i < len && j < len) {
//            if (mark[j][i] == 2) {
//                return false;
//            }
//            i--;
//            j++;
//        }
//
//        return true;
//    }

}
