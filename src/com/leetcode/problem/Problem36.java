package com.leetcode.problem;

/**
 * Valid Sudoku
 *
 * If possible, use Array for hash table or hash set, which is faster.
 */
public class Problem36 {
    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            boolean[] filled = new boolean[9];
            for (char num :
                    board[row]) {
                if (num == '.') {
                    continue;
                }
                int number = num - '1';
                if (filled[number]) {
                    return false;
                }
                filled[number] = true;
            }
        }

        for (int col = 0; col < board.length; col++) {
            boolean[] filled = new boolean[9];
            for (int row = 0; row < board.length; row++) {
                char num = board[row][col];
                if (num == '.') {
                    continue;
                }
                int number = num - '1';
                if (filled[number]) {
                    return false;
                }
                filled[number] = true;
            }
        }

        for (int startRow = 0; startRow < 9; startRow += 3) {
            for (int startCol = 0; startCol < 9; startCol += 3) {
                boolean[] filled = new boolean[9];
                for (int i = startRow; i < startRow + 3; i++) {
                    for (int j = startCol; j < startCol + 3; j++) {
                        if (board[i][j] == '.') {
                            continue;
                        }
                        int number = board[i][j] - '1';
                        if (filled[number]) {
                            return false;
                        }
                        filled[number] = true;
                    }
                }
            }
        }

        return true;
    }
}
