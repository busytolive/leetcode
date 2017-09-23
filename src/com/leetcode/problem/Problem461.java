package com.leetcode.problem;

/**
 * Hamming Distance
 *
 * Note: simple is beautiful. Use library as much as possible.
 */
public class Problem461 {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
