package com.leetcode.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains Duplicate II
 *
 * HashTable.
 * TODO: try to do it by HashSet. keep size at most K
 */
public class Problem219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> valueToIndex = new HashMap<>(); // <value, index> is the index of last occurred value in the array
        for (int i = 0; i < nums.length; i++) {
            if (valueToIndex.containsKey(nums[i]) && (i - valueToIndex.get(nums[i])) <= k) {
                return true;
            }
            valueToIndex.put(nums[i], i);
        }
        return false;
    }
}
