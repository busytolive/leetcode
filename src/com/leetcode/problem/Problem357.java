package com.leetcode.problem;

/**
 * Count Numbers with Unique Digits
 *
 * Backtrack is brute force. should always prefer smarter solution
 *
 * This is a digit COMBINATION problem. Can be solved in at most 10 loops.
 * https://leetcode.com/problems/count-numbers-with-unique-digits/discuss/
 */
public class Problem357 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }

        int totalCount = 10, countOfCurrentLevel = 9;
        for (int numOfDigits = 2; numOfDigits <= n && numOfDigits <= 10; numOfDigits++) {
            countOfCurrentLevel = countOfCurrentLevel * (9 - numOfDigits + 2);
            totalCount += countOfCurrentLevel;
        }
        return totalCount;
    }
}
