package com.leetcode.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }

        int max = 0;
        int maxSize = 0;
        Arrays.sort(nums);
        int[] maxSubsetSizes = new int[nums.length];
        int[] pres = new int[nums.length];
        maxSubsetSizes[0] = 1;
        pres[0] = -1;
        for (int i = 1; i < nums.length; i++) {
            pres[i] = -1;
            maxSubsetSizes[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && maxSubsetSizes[j] + 1 > maxSubsetSizes[i]) {
                    maxSubsetSizes[i] = maxSubsetSizes[j] + 1;
                    pres[i] = j;
                }
            }
            if (maxSubsetSizes[i] > maxSize) {
                maxSize = maxSubsetSizes[i];
                max = i;
            }
        }

        List<Integer> result = new ArrayList<>();
        do {
            result.add(nums[max]);
            max = pres[max];
        } while (max != -1);

        return result;
    }
}
