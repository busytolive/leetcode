package com.leetcode.problem;

/**
 * Best Time to Buy and Sell Stock with Cooldown
 *
 * Think about Dynamic Programming problems in "State Machine"
 */
public class Problem309 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int buy = -prices[0], sell = Integer.MIN_VALUE, rest = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = buy;
            buy = Math.max(buy, rest - prices[i]);
            rest = Math.max(rest, sell);
            sell = tmp + prices[i];
        }
        return Math.max(buy, Math.max(sell, rest));
    }
}
