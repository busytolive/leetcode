package com.leetcode.problem;

/**
 * Poor Pigs
 *
 * identify a bucket with a (minutesToTest / minutesToDie + 1) dimension array:
 * [d1, d2, d3, ... , dn], n = minutesToTest / minutesToDie + 1
 * Use one pig to find the the value of one dimension.
 */
public class Problem458 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int dimensionLength = minutesToTest / minutesToDie + 1;
        int numOfPigs = 0;
        while (Math.pow(dimensionLength, numOfPigs) < buckets) {
            numOfPigs++;
        }
        return numOfPigs;
    }
}
