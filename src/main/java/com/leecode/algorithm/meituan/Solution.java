package com.leecode.algorithm.meituan;


public class Solution {

//    public static void main(String[] agrs) {
//        Solution s=new Solution();
//        int a = s.maxProfit(new int[]{1,9,6,9,1,7,1,1,5,9,9,9});
//    }
    /**
     *
     * @param prices int整型一维数组
     * @return int整型
     */
//    public int maxProfit (int[] prices) {
//        int profit = 0;
//        boolean buy = false;
//        int buy_pos = 0;
//        for (int i = 0; i < prices.length; i++){
//            if ((i+1) == prices.length ) {
//                // 如果是买的状态下需要清仓
//                if (buy) {
//                    profit += prices[i] - prices[buy_pos];
//                }
//                return profit;
//            }
//            // 下一天比当天高则买入或持有，下一天比当天低则当天卖出
//            int cur_price = prices[i];
//            int next_price = prices[i+1];
//            if (cur_price > next_price) {
//                // 卖
//                profit += cur_price - prices[buy_pos];
//                buy = false;
//            } else {
//                // 买 或 持有
//                if (buy == true){
//                    // 持有
//                } else {
//                    // 买
//                    buy = true;
//                    buy_pos = i;
//                }
//
//            }
//        }
//
//        return profit;
//    }
}
