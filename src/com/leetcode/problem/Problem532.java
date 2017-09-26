package com.leetcode.problem;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * K-diff Pairs in an Array
 *
 * Note: the key point is count the occurrence of each integer first("pre-process")
 */
public class Problem532 {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0)   return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1); // <i, j> mean integer i occurs j times
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                //count how many elements in the array that appear more than twice.
                if (entry.getValue() >= 2) {
                    count++;
                }
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }

        return count;
    }
}
