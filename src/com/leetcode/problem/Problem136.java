package com.leetcode.problem;

/**
 * Single Number
 *
 * Bit operation, XOR
 */
public class Problem136 {
    public int singleNumber(int[] nums) {
        int unique = 0;
        for (int i : nums) {
            unique ^= i;
        }
        return unique;
    }
}
