package com.leetcode.problem;

/**
 * Single Element in a Sorted Array
 *
 * binary search
 */
public class Problem540 {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        /**
         * loop invariant: the single element is in nums[left, right]
         */
        while (left <= right) {
            if (left == right) { // only one element between left and right, which is the single element
                return nums[left];
            }

            // remove elements in pairs from the search scope: [left, right]
            int middle = left + (right - left) / 2;
            int numRight = right - middle;
            int numLeft = middle - left;
            if (numRight % 2 == 0 && nums[middle] < nums[middle + 1]) {
                right = middle;
            } else if (numRight % 2 == 1 && nums[middle] == nums[middle + 1]) {
                right = middle - 1;
            } else if (numLeft % 2 == 0 && nums[middle - 1] < nums[middle]) {
                left = middle;
            } else if (numLeft % 2 == 1 && nums[middle - 1] == nums[middle]) {
                left = middle + 1;
            }
        }
        return nums[0];
    }
}
