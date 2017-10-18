package com.leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class Problem216 {
    List<List<Integer>> solutions = new ArrayList<>();
    int expectedSum;
    int length;

    public List<List<Integer>> combinationSum3(int k, int n) {
        boolean[] used = new boolean[10];
        expectedSum = n;
        length = k;
        backtrack(0, used);
        return solutions;
    }

    private void backtrack(int sum, boolean[] used) {
        // keep searching
        if (sum < expectedSum && numberOfInteger(used) < length) {
            for (int i = getLastUsed(used) + 1; i <= 9; i++)  {
                if (!used[i]) {
                    used[i] = true;
                    backtrack(sum + i, used);
                    used[i] = false;
                }
            }
        }

        // solution found
        if (sum == expectedSum && numberOfInteger(used) == length) {
            solutions.add(generateSolution(used));
        }
    }

    private int numberOfInteger(boolean[] used) {
        int num = 0;
        for (int i = 1; i <= 9; i++) {
            if (used[i]) {
                num++;
            }
        }
        return num;
    }

    private List<Integer> generateSolution(boolean[] used) {
        List<Integer>  solution = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            if (used[i]) {
                solution.add(i);
            }
        }
        return solution;
    }

    private int getLastUsed(boolean[] used) {
        for (int i = 9; i >= 1; i--) {
            if (used[i]) {
                return i;
            }
        }
        return 0;
    }
}
