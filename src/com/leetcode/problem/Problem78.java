package com.leetcode.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * Subsets
 */
public class Problem78 {
    private List<List<Integer>> subsets = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        boolean[] select = new boolean[nums.length];
        backtrack(select, 0, nums);
        return subsets;
    }

    private void backtrack(boolean[] select, int i, int[] nums) {
        if (i == select.length) {
            subsets.add(getSubset(select, nums));
            return;
        }

        select[i] = true;
        backtrack(select, i + 1, nums);
        select[i] = false;
        backtrack(select, i + 1, nums);
    }

    private List<Integer> getSubset(boolean[] select, int[] nums) {
        List<Integer> subset = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if (select[i]) {
                subset.add(nums[i]);
            }
        }
        return subset;
    }
}
