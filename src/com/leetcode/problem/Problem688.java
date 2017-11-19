package com.leetcode.problem;

import com.leetcode.library.Point;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Knight Probability in Chessboard
 *
 * Dynamic(table) programming
 *
 * TODO: use iteration instead of recursion to improve latency
 */
public class Problem688 {
    private static int[] deltaCol = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
    private static int[] deltaRow = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
    private double[][][] table = new double[25][25][101];

    public Problem688() {
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                Arrays.fill(table[i][j], -1);
            }
        }
    }

    public double knightProbability(int N, int K, int r, int c) {
        if (table[r][c][K] >= 0) {
            return table[r][c][K];
        }

        double probability = 0;
        if (K == 0) {
            probability = 1;
        } else {
            for (Point next :
                    nextPointsOnBoard(N, r, c)) {
                probability += knightProbability(N, K - 1, next.x, next.y);
            }
            probability /= 8;
        }
        table[r][c][K] = probability;
        return probability;
    }

    private List<Point> nextPointsOnBoard(int N, int r, int c) {
        List<Point> points = new LinkedList<>();
        for(int i = 0; i < 8; i++) {
            int nextR = r + deltaRow[i];
            int nextC = c + deltaCol[i];
            if (nextR >= 0 && nextR <= N - 1 && nextC >= 0 && nextC <= N - 1) {
                points.add(new Point(nextR, nextC));
            }
        }
        return points;
    }
}
