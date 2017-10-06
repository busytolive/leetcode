package com.leetcode.problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Increasing Subsequences
 *
 * Backtracking.
 * HashSet can work well with List to de-duplicate
 */
public class Problem491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> acceptable = new ArrayList<>();
        findSequence(result, acceptable, 0, nums);
        return new ArrayList(result);
    }

    /**
     *
     * @param res all solutions to return
     * @param acceptable state: CURRENT acceptable/node
     * @param index state: start index of NEXT possible solutions
     * @param nums number list
     */
    public void findSequence(Set<List<Integer>> res, List<Integer> acceptable, int index, int[] nums) {
        if (acceptable.size() >= 2) { // found a solution
            res.add(new ArrayList(acceptable));
        }
        for (int i = index; i < nums.length; i++) {
            if(acceptable.size() == 0 || acceptable.get(acceptable.size() - 1) <= nums[i]) {
                acceptable.add(nums[i]);
                findSequence(res, acceptable, i + 1, nums);
                acceptable.remove(acceptable.size() - 1);
            }
        }
    }
}
