package com.leetcode.problem;

/**
 * Rotate Image
 */
public class Problem48 {
    public void rotate(int[][] matrix) {
        int size = matrix.length;

        // transpose. 求转置矩阵：行列互换
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // flip the matrix horizontally. 水平镜面翻转
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][size - 1 - j];
                matrix[i][size - 1 -j] = temp;
            }
        }
    }
}
