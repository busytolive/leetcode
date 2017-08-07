package com.leetcode.problem;

public class Problem63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int col, row;
        int[][] uniquePaths;

        row = obstacleGrid.length;
        if (row == 0) return 0;

        col = obstacleGrid[0].length;
        if (col == 0) return 0;

        uniquePaths = new int[row][col];
        uniquePaths[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < row; i++) {
            uniquePaths[i][0] = obstacleGrid[i][0] == 1 ? 0 : uniquePaths[i - 1][0];
        }
        for (int j = 1; j < col; j++) {
            uniquePaths[0][j] = obstacleGrid[0][j] == 1 ? 0 : uniquePaths[0][j - 1];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    uniquePaths[i][j] = 0;
                } else {
                    uniquePaths[i][j] += uniquePaths[i - 1][j] + uniquePaths[i][j - 1];
                }
            }
        }

        return uniquePaths[row - 1][col - 1];
    }
}
