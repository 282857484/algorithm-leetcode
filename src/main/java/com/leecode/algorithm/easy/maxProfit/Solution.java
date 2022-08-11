package  com.leecode.algorithm.easy.maxProfit;

/**
 * 121. 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2：
 *
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 *
 * 提示：
 *
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 */
class Solution {
    public static void main(String[] agrs) {
        Solution s=new Solution();
        int a = s.maxProfit(new int[]{3,3,5,0,0,3,1,4});
        System.out.println(a);
    }

    /**
     * 只能买一次
     * 假设法
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        // 记录历史最低价
        int minprice = Integer.MAX_VALUE;
        int max = 0;
        // 假设我们已经在历史最低价买入，我第i天能赚多少钱
        for (int i = 0; i < prices.length; i++) {
            if (minprice > prices[i]) {
                minprice = prices[i];
            } else {
                int profit = prices[i] - minprice;
                if (profit > max) {
                    max = profit;
                }
            }
        }

        return max;
    }
    public int maxProfitDp(int[] prices) {
        int profit = 0;
        int last = 0;
        for (int i = 1; i < prices.length; i++) {
            last = Math.max(last + prices[i] - prices[i-1], 0);
            profit = Math.max(profit, last);
        }
        return profit;
    }
    public int maxProfitDp2(int[] prices) {
        int profit = 0;
        int[] dp = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i-1] + prices[i] - prices[i-1], 0);
            profit = Math.max(profit, dp[i]);
        }
        return profit;
    }

}
