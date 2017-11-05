package com.leetcode.problem;

import java.util.Arrays;

/**
 * Minimum Moves to Equal Array Elements II
 *
 * A math problem: we have the minimum sum of distance if the unified value is median(中位数)
 * TODO: understand the proof of the math problem.
 */
public class Problem462{
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += Math.abs(nums[i] - nums[nums.length/2]);
        }
        return sum;
    }
}
