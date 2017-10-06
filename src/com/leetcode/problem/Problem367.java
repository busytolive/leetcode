package com.leetcode.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * Valid Perfect Square
 *
 * Algorithm: https://en.wikipedia.org/wiki/Integer_square_root#Algorithm_using_Newton.27s_method
 */
public class Problem367 {
    public boolean isPerfectSquare(int num) {
        long root = num;
        while (root * root > num) {
            root = (root + num / root) >> 1;
        }
        return root * root == num;
    }
}
