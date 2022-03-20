package com.leecode.algorithm.middle.spiralOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 */
public class Solution {
    public static void main(String[] args) {
        Solution s =new Solution();
        List l = s.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int total = matrix.length * matrix[0].length;
        List<Integer> list = new ArrayList(total);
        int i = 0;
        int j = 0;
        // 方向顺序是先0-(i,j+1) 1-(i+1,j) 2-(i,j-1) 3-(i-1,j)
        int status = 0;
        list.add(matrix[0][0]);
        matrix[0][0] = Integer.MIN_VALUE;
        while (list.size() != total) {
            switch (status){
                case 1:
                    if ((i+1) < matrix.length && matrix[i+1][j] > Integer.MIN_VALUE) {
                        i++;
                        list.add(matrix[i][j]);
                        matrix[i][j] = Integer.MIN_VALUE;
                    } else {
                        status = (status+1) % 4;
                    }
                    break;
                case 0:
                    if ((j+1) < matrix[0].length && matrix[i][j+1] > Integer.MIN_VALUE) {
                        j++;
                        list.add(matrix[i][j]);
                        matrix[i][j] = Integer.MIN_VALUE;
                    } else {
                        status = (status+1) % 4;
                    }
                    break;
                case 3:
                    if ((i-1) >= 0 && matrix[i-1][j] > Integer.MIN_VALUE) {
                        i--;
                        list.add(matrix[i][j]);
                        matrix[i][j] = Integer.MIN_VALUE;
                    } else {
                        status = (status+1) % 4;
                    }
                    break;
                case 2:
                    if ((j-1) >=0 && matrix[i][j-1] > Integer.MIN_VALUE) {
                        j--;
                        list.add(matrix[i][j]);
                        matrix[i][j] = Integer.MIN_VALUE;
                    } else {
                        status = (status+1) % 4;
                    }
                    break;
            }
        }
        return list;
    }
}
