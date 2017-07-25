package com.leetcode.problem;

/**
 * Unique Paths
 *
 * Notes: Dynamic programming with iteration
 */
public class Problem62 {
    public int uniquePaths(int m, int n) {
        int[][] uniquePathNum = new int[m][n];
        /*
         * let uniquePathNum[row][col] stores unique paths from [0,0] to [row][col],
         * uniquePathNum[row][col] = uniquePathNum[row - 1][col] + uniquePathNum[row][col - 1]
         */
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (row == 0 || col == 0) {
                    uniquePathNum[row][col] = 1;
                } else {
                    uniquePathNum[row][col] = uniquePathNum[row - 1][col] + uniquePathNum[row][col - 1];
                }
            }
        }
        return uniquePathNum[m - 1][n - 1];
    }
}
