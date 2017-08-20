package com.leetcode.problem;

import com.leetcode.library.GuessGame;

/**
 * Guess Number Higher or Lower
 *
 * Binary search
 *
 * WARNING: (low+high)/2 may lead to integer overflow! Use low+(high-low)/2 instead.
 */
public class Problem374 extends GuessGame {
    public int guessNumber(int n) {
        return binaryGuess(1, n);
    }

    private int binaryGuess(int low, int high) {
        int myGuess = low + (high - low) / 2;
        int guessResult = guess(myGuess);
        if (guessResult == 0) {
            return myGuess;
        } else if (guessResult < 0) {
            return binaryGuess(low, myGuess - 1);
        } else {
            return binaryGuess(myGuess + 1, high);
        }
    }
}
