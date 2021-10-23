package com.leecode.algorithm.middle.numisland;

import java.util.LinkedList;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] grid = {{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}};
        System.out.println(s.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        int islandNum = 0;
        int xlength = grid.length;
        int ylength = grid[0].length;
        for (int x = 0; x < xlength; x++) {
            for (int y = 0; y < ylength; y++) {
                if (grid[x][y] == 49) {
                    islandNum++;
                    infect(grid, x, y);
                }
            }
        }
        return islandNum;
    }

    private void infect(char[][] grid, int x, int y) {
        if (grid[x][y] == 49) {
            grid[x][y] = 50;
            if ((x - 1) >= 0) {
                if (grid[x - 1][y] == 49) {
                    infect(grid, x - 1, y);
                }
            }
            if ((y - 1) >= 0) {
                if (grid[x][y - 1] == 49) {
                    infect(grid, x, y - 1);
                }
            }
            if ((x + 1) < grid.length) {
                if (grid[x + 1][y] == 49) {
                    infect(grid, x + 1, y);
                }
            }
            if ((y + 1) < grid[x].length) {
                if (grid[x][y + 1] == 49) {
                    infect(grid, x, y + 1);
                }
            }
        }
    }

}