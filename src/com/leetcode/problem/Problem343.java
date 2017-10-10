package com.leetcode.problem;

/**
 * Integer Break
 *
 * Dynamic Programing by "bottom-up": solution for any sub-problem ONLY depends on smaller sub-problem(s)
 */
public class Problem343 {
    public int integerBreak(int n) {
        int[] maxProduct = new int[n + 1];
        maxProduct[1] = 1;
        maxProduct[2] = 1;
        for (int i = 3; i <= n; i++) {
            int max = 0;
            for (int j = 2; j < i; j++) {
                if (j * maxProduct[i - j] > max) {
                    max = j * maxProduct[i - j];
                }

                if (j * (i - j) > max) {
                    max = j * (i - j);
                }
            }
            maxProduct[i] = max;
        }
        return maxProduct[n];
    }
}
