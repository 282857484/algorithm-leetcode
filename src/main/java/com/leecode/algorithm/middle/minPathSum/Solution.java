package com.leecode.algorithm.middle.minPathSum;


import java.util.Arrays;

public class Solution {
    // 动态规划
    // dp[i][j] = min{dp[i-1][j] + a[i][j], dp[i][j-1] + a[i][j] }
    public int minPathSum(int[][] grid) {
        int m = grid[0].length;
        int n = grid.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < m; i++) {
            dp[0][i + 1] = grid[0][i] + dp[0][i];
        }
        for (int i = 0; i < n; i++) {
            dp[i + 1][0] = grid[i][0] + dp[i][0];
        }
        if (m == 1 && n == 1) {
            return grid[0][0];
        }
        if (m == 1) {
            return dp[n][0];
        }
        if (n == 1) {
            return dp[0][m];
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (i == 0 && j == 0) {
                    dp[j + 1][i + 1] = grid[0][0];
                } else {
                    dp[j + 1][i + 1] = Math.min(dp[j + 1][i] + grid[j][i], dp[j][i + 1] + grid[j][i]);
                }

            }
        }
        return dp[n][m];
    }

    // 深度搜索-回溯算法
    public int minPathSumDeepSearch(int[][] grid) {
        return 0;
    }

    public int minPathSum1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(cache[i], -1);
        }
        return dfs(m - 1, n - 1, grid, cache);
    }
    //备忘录法递归
    public int dfs(int x, int y, int[][] grid, int[][] cache) {
        if (x < 0 || y < 0) return Integer.MAX_VALUE;
        if (x == 0 && y == 0) return grid[0][0];
        if (cache[x][y] != -1) return cache[x][y];
        cache[x][y] = Math.min(dfs(x - 1, y, grid, cache), dfs(x, y - 1, grid, cache)) + grid[x][y];
        return cache[x][y];
    }
}