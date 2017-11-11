package com.leetcode.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * Find All Numbers Disappeared in an Array
 *
 * The basic idea is that we iterate through the input array. for nums[i], change nums[nums[i] - 1] to negative.
 * After the iteration if there is a element is not negative, then the index is not is in the array.
 */
public class Problem448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }
}
