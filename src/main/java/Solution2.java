class Solution1 {
    public static void main(String[] args) {
//        Solution s= new Solution();
        System.out.println("结果:");

        // for (T t : s.func()) { System.out.println("结果:" + t);}
    }
//1、排序算法
//
    //2、最小路径和：给定一个包含非负整数的 m*n 网格 grid ，找出一条从左上角到右下角的路径（路径的方向只能向下或向右），使得路径上的数字总和为最小。
//    class Solution {
//        public int minPathSum(int[][] grid) {
//
//        }
//    }

    //3、最长重复子串：给出一个字符串S，考虑其所有重复子串（S的连续子串，出现两次或多次，可能会有重叠）,返回长度最长的重复子串。（如果不含重复子串，那么答案为 ""）。例如：输入"banana"，输出"ana"；输入"abcd"，输出""
//    class Solution {
//        public String longestDupSubstring(String s) {
//
//        }
//    }

    //1、排序算法

    //2、最小路径和：给定一个包含非负整数的 m*n 网格 grid ，找出一条从左上角到右下角的路径（路径的方向只能向下或向右），使得路径上的数字总和为最小。
//    class Solution {
//        public int minPathSum(int[][] grid) {
//            // dp
//            int [][] dp = new int [grid.length][grid[0].length];
//            // init
//            for (int i=1; i<grid.length; i++){
//                dp[i][0]=dp[i-1][0]+grid[i][0];
//            }
//            for (int j=1; i<grid[0].length; i++){
//                dp[0][j]=dp[0][j-1]+grid[0][j];
//            }
//            // dp[i][j]的值是从左或者是从上来的值中最小的加本单元的值
//            for(int i = 1; i < grid.length; i++){
//                for(int j = 1; j<grid[0].length; j++){
//                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+grid[i][j];
//                }
//            }
//            return dp[grid.length][grid[0].length];
//        }
//    }

    //3、最长重复子串：给出一个字符串S，考虑其所有重复子串（S的连续子串，出现两次或多次，可能会有重叠）,返回长度最长的重复子串。（如果不含重复子串，那么答案为 ""）。例如：输入"banana"，输出"ana"；输入"abcd"，输出""
//    class Solution {
//        public String longestDupSubstring(String s) {
//            // 动态规划
//
//        }
//    }
}