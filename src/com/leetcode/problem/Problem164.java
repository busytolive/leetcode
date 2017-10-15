package com.leetcode.problem;

import java.util.Arrays;

/**
 * Maximum Gap
 *
 * TODO: use O(n) time to be faster
 */
public class Problem164 {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        Arrays.sort(nums);
        int maxGap = nums[1] - nums[0];
        for (int i = 2; i < nums.length; i++) {
            maxGap = Math.max(maxGap, nums[i] - nums[i - 1]);
        }
        return  maxGap;
    }
}
