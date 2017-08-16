package com.leetcode.problem;

/**
 * Find the Difference
 *
 * bit-operation
 */
public class Problem389 {
    public char findTheDifference(String s, String t) {
        char difference = 0;
        for (char origin: s.toCharArray()) {
            difference ^= origin;
        }
        for (char after : t.toCharArray()) {
            difference ^= after;
        }
        return difference;
    }
}
