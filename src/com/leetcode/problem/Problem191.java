package com.leetcode.problem;

/**
 * Number of 1 Bits
 *
 * bitwise operator >>> : unsigned right shift, 0 will be appended to the left.
 */
public class Problem191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += n & 0x1;
            n >>>= 1;
        }
        return count;
    }
}
