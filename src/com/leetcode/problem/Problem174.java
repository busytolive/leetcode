package com.leetcode.problem;

/**
 * Dungeon Game
 *
 * Note: 2D Array, DP by iteration
 */
public class Problem174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] minInitialHP = new int[row][col];

        minInitialHP[row - 1][col - 1] = dungeon[row - 1][col - 1] >= 0 ? 1 : 1 - dungeon[row - 1][col - 1];

        for (int j = col - 2; j >= 0; j--) {
            minInitialHP[row - 1][j] = dungeon[row - 1][j] >= minInitialHP[row - 1][j + 1] ? 1 :
                    minInitialHP[row - 1][j + 1] - dungeon[row - 1][j];
        }

        for (int i = row - 2; i >= 0; i--) {
            minInitialHP[i][col - 1] = dungeon[i][col - 1] >= minInitialHP[i + 1][col - 1] ? 1 :
                    minInitialHP[i + 1][col - 1] - dungeon[i][col - 1];
        }

        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                int nextMinHP = Math.min(minInitialHP[i][j + 1], minInitialHP[i + 1][j]);
                minInitialHP[i][j] = dungeon[i][j] >= nextMinHP ? 1 : nextMinHP - dungeon[i][j];
            }
        }

        return minInitialHP[0][0];
    }
}
