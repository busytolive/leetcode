package com.leetcode.problem;

/**
 * Maximum Product Subarray
 *
 * Sometimes we need multiple states from sub-problems to get solution for the bigger problem,
 * like "imax" and "imin" here.
 */
public class Problem152 {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        // imax/imin stores the max/min product of
        // subarray that ends with the current number A[i]
        for (int i = 1, imax = max, imin = max; i < nums.length; i++) {
            // multiplied by a negative makes big number smaller, small number bigger
            if (nums[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }

            // update imax and imin
            imax = Math.max(nums[i], imax * nums[i]);
            imin = Math.min(nums[i], imin * nums[i]);

            // update max
            max = Math.max(max, imax);
        }
        return max;
    }
}
