package com.leetcode.problem;

/**
 * 2 Keys Keyboard
 *
 * Key Point to simplify the iteration algorithm: you can only copy ALL.
 */
public class Problem650 {
    public int minSteps(int n) {
        int[] dp = new int[n+1];
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = i-1; j > 1; j--) {
                if (i % j == 0) {
                    dp[i] = dp[j] + (i/j);
                    break;
                }
            }
        }
        return dp[n];
    }
}
