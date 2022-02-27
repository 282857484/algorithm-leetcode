package src.main.java.com.leecode.algorithm.easy.maxProfit;

import java.util.Arrays;

class Solution {
    public static void main(String[] agrs) {
        Solution s=new Solution();
        int a = s.maxProfitIII(new int[]{3,3,5,0,0,3,1,4});
        System.out.println(a);
    }
    // 只能买一次

    /**
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。
     * 设计一个算法来计算你所能获取的最大利润。
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     *
     * @param prices
     * @return
     */
    public int maxProfitI(int[] prices) {
        return maxProfit(prices);
    }

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

    // 买卖股票的最佳时机 II

    /**
     * 在每一天，你可能会决定购买和/或出售股票。
     * 你在任何时候 最多 只能持有 一股 股票。
     * 你也可以购买它，然后在 同一天 出售。
     * 返回 你能获得的 最大 利润 。
     * 
     * @param prices
     * @return
     */
    public int maxProfitII(int[] prices) {
        boolean flag = false; // false空仓、true满仓
        int money = 0;

        int[] buyflag = new int[prices.length]; // 涨跌flag
        for (int i = 1; i < prices.length; i++) {
            buyflag[i] = prices[i] - prices[i-1];
        }

        for (int i = 0; i < buyflag.length; i++) {
            if (buyflag[i] > 0) {
                money += buyflag[i];
            }
        }
        return money;
    }

    // 123. 买卖股票的最佳时机 III
    /**
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * @param prices
     * @return
     */
    public int maxProfitIII(int[] prices) {
        // ????????????????傻逼玩意，不研究这个玩意了
        int n = prices.length;
        int buy1 = prices[0], sell1 = 0;
        int buy2 = prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.min(buy1, prices[i]);
            sell1 = Math.max(sell1, prices[i] - buy1);
            buy2 = Math.min(buy2, prices[i] - sell1);
            sell2 = Math.max(sell2, prices[i] - buy2);
        }
        return sell2;
    }
    public int maxProfitIIIX(int[] prices) {
        int maxTwice = 0;
        for (int i = 2; i < prices.length + 1; i++) {
            int a = maxProfitIIIXX(prices,0, i);
            int b = maxProfitIIIXX(prices, i, prices.length);
            maxTwice = Math.max(maxTwice, (a + b));
        }
        return maxTwice;
    }
    public int maxProfitIIIXX(int[] prices, int i, int j) {
        // 记录历史最低价
        int minprice = Integer.MAX_VALUE;
        int max = 0;
        // 假设我们已经在历史最低价买入，我第i天能赚多少钱
        for (; i < j; i++) {
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

}
