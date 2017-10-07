package com.leetcode.problem;

/**
 * Power of Four
 *
 * 1. tell if a bit pattern contains only one 1: i & i - 1
 * 2. java operator precedence: logical operator(like ==) has higher priority than bit operators(like &)
 */
public class Problem342 {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & num - 1) == 0 && (num & 0x55555555) > 0;
    }
}
