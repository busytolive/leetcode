package com.leetcode.problem;

/**
 * Android Unlock Patterns
 * <p>
 * Note: backtracking
 * <p>
 * https://web.archive.org/web/20070317015632/http://www.cse.ohio-state.edu/~gurari/course/cis680/cis680Ch19.html#QQ1-51-128
 */
public class Problem351 {
    private static int[][] passThrough; // The line connecting key i and j passes through key passThrough[i][j]
    private static boolean selected[] = new boolean[10];

    public int numberOfPatterns(int m, int n) {
        constructPassThroughArray();
        int numPatterns = 0;
        for (int i = m; i <= n; ++i) {
            numPatterns += backtrack(1, i - 1) * 4;    // 1, 3, 7, 9 are symmetric
            numPatterns += backtrack(2, i - 1) * 4;    // 2, 4, 6, 8 are symmetric
            numPatterns += backtrack(5, i - 1);        // 5
        }
        return numPatterns;
    }

    private void constructPassThroughArray() {
        passThrough = new int[10][10];

        passThrough[1][3] = passThrough[3][1] = 2;
        passThrough[1][7] = passThrough[7][1] = 4;
        passThrough[3][9] = passThrough[9][3] = 6;
        passThrough[7][9] = passThrough[9][7] = 8;

        passThrough[2][8] = passThrough[8][2] = passThrough[4][6] = passThrough[6][4] = 5;

        passThrough[1][9] = passThrough[9][1] = passThrough[3][7] = passThrough[7][3] = 5;
    }

    private int backtrack(int currKey, int numOfAdditionalKeysToSelect) {
        selected[currKey] = true;

        if (numOfAdditionalKeysToSelect == 0) { // solution accepted
            selected[currKey] = false;
            return 1;
        }

        int sum = 0;
        // construct next possible partial solutions
        for (int i = 1; i <= 9; ++i) {
            // If key i has not been and (selected and j are adjacent or passThrough number has been selected)
            if (!selected[i] && (passThrough[currKey][i] == 0 || (selected[passThrough[currKey][i]]))) {
                sum += backtrack(i, numOfAdditionalKeysToSelect - 1); // accept key i as partial solution
            }
        }
        selected[currKey] = false;
        return sum;
    }
}
