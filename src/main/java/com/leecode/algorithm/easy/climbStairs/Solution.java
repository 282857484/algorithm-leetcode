package src.main.java.com.leecode.algorithm.easy.climbStairs;

//70. 爬楼梯

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
class Solution {
    public int climbStairsX(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }
    // 斐波那契数列

    /**
     * dp[i - 1] 与 dp[i - 2]是不相交的独立走法
     * 反证法：dp[i - 1]与dp[i - 2]如果走法一样的话，那么走的台阶数应该是一样的
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}