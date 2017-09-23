package com.leetcode.problem;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * K-diff Pairs in an Array
 */
public class Problem532 {
    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }

        int numOfPairs = 0;
        Map<Integer, Integer> expect2origin = new HashMap<>();
        Map<Integer, Integer> foundPairs = new HashMap<>();
        for (int num : nums) {
            int expectedLeft = num - k;
            int expectedRight = num + k;
            if (!expect2origin.containsKey(num)) {
                if (!(foundPairs.containsKey(expectedLeft) && foundPairs.get(expectedLeft) == num)) {
                    expect2origin.put(expectedLeft, num);
                }
                if (!(foundPairs.containsKey(expectedRight) && foundPairs.get(expectedRight) == num)) {
                    expect2origin.put(expectedRight, num);
                }
            } else {
                numOfPairs++;
                int origin = expect2origin.get(num);
                foundPairs.put(origin, num);
                foundPairs.put(num, origin);
                if (!(foundPairs.containsKey(expectedLeft) && foundPairs.get(expectedLeft) == num)) {
                    expect2origin.put(expectedLeft, num);
                }
                if (!(foundPairs.containsKey(expectedRight) && foundPairs.get(expectedRight) == num)) {
                    expect2origin.put(expectedRight, num);
                }
                expect2origin.remove(num);
            }
        }
        return numOfPairs;
    }
}
