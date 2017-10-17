package com.leetcode.problem;

public class Problem121 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int[] maxProfits = new int[prices.length];
        maxProfits[prices.length - 1] = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
            if (prices[i + 1] - prices[i] + maxProfits[i + 1] > 0) {
                maxProfits[i] = prices[i + 1] - prices[i] + maxProfits[i + 1];
            } else {
                maxProfits[i]  = 0;
            }
        }

        int max = maxProfits[0];
        for (int i = 1; i < maxProfits.length; i++) {
            if (maxProfits[i] > max) {
                max = maxProfits[i];
            }
        }
        return max;
    }
}
