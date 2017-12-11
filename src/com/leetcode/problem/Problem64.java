package com.leetcode.problem;

public class Problem64 {
    public int minPathSum(int[][] grid) {
        int rowSize = grid.length;
        if (rowSize < 1) {
            return 0;
        }
        int colSize = grid[0].length;
        if (colSize < 1) {
            return 0;
        }

        int[][] minPathSum = new int[rowSize][colSize];
        minPathSum[rowSize - 1][colSize - 1] = grid[rowSize - 1][colSize - 1];

        for (int col = colSize - 2; col >= 0; col--) {
            minPathSum[rowSize - 1][col] = grid[rowSize - 1][col] + minPathSum[rowSize - 1][col + 1];
        }

        for (int row = rowSize - 2; row >= 0; row--) {
            minPathSum[row][colSize - 1] = grid[row][colSize - 1] + minPathSum[row + 1][colSize - 1];
        }

        for (int row = rowSize - 2; row >= 0; row--) {
            for (int col = colSize - 2; col >= 0; col--) {
                minPathSum[row][col] = grid[row][col] + Math.min(minPathSum[row][col + 1], minPathSum[row + 1][col]);
            }
        }

        return minPathSum[0][0];
    }
}
