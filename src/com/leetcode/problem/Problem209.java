package com.leetcode.problem;

/**
 * Minimum Size Subarray Sum
 *
 * two pointers. Array.
 *
 * Time complexity: Each element can be visited at most twice, once by the right pointer(i) and at most once by the
 * start pointer
 */
public class Problem209 {
    public int minSubArrayLen(int s, int[] nums) {
        int start = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                minLength = Math.min(minLength, i - start + 1);
                sum -= nums[start++];
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
