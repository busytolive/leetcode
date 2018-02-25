package com.leetcode.problem;

/**
 * Majority Element
 */
public class Problem169 {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) { // no candidate on the stage, so the next person becomes candidate
                candidate = nums[i];
                count = 1;
            }
            else if (nums[i] == candidate)  {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}
