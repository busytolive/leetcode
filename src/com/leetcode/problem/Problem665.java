package com.leetcode.problem;

public class Problem665 {
    public boolean checkPossibility(int[] nums) {
        int found = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (found >= 0) {
                    return false;
                }
                found = i;
            }
        }

        return found == -1 || found == 0 || found == nums.length - 2 || nums[found] <= nums[found + 2] || nums[found - 1] <= nums[found + 1];
    }
}
