package com.leetcode;

import com.leetcode.library.Interval;
import com.leetcode.library.ListNode;
import com.leetcode.problem.*;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,4,8};
        System.out.println(new Problem368().largestDivisibleSubset(nums));
    }
}
