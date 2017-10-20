package com.leetcode.problem;

public class Problem581 {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int[] min = new int[nums.length];
        min[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            min[i] = Math.min(nums[i], min[i + 1]);
        }

        int[] max = new int[nums.length];
        max[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(nums[i], max[i - 1]);
        }

        int start;
        for (start = 0; start < nums.length - 1; start++) {
            if (nums[start] > min[start + 1]) {
                break;
            }
        }
        int end;
        for (end = nums.length - 1; end >= 1; end--) {
            if (nums[end] < max[end - 1]) {
                break;
            }
        }
        return end - start + 1 < 0 ? 0 : end - start + 1;
    }
}
