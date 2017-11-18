package com.leetcode.problem;

/**
 * Missing Number
 */
public class Problem268 {
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int abs = Math.abs(nums[i]);
            if (abs < nums.length) {
                nums[abs] = -1 * nums[abs];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1) {
                return i;
            }
        }

        return nums.length;
    }
}
