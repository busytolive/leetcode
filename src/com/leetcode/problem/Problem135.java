package com.leetcode.problem;
import java.util.Arrays;

/**
 * Candy
 *
 * Notes: divide and conquer. Divide the original rule into two separate rules: relative to left neighbour only and
 * relative to right neighbour only, which are both easy to follow.
 *
 * Way to prove the correctness of the algorithm: for any three students [s1, s2, s3] who stands next to each
 * other, we can easily to prove whatever ratings they have. The number of candies student s2 finally gets satisfies the
 * original rule
 */
public class Problem135 {
    public int candy(int[] ratings) {
        int sum = 0;
        int[] left2right = new int[ratings.length];
        int[] right2left = new int[ratings.length];

        Arrays.fill(left2right, 1);
        Arrays.fill(right2left, 1);

        // The student with a higher rating than its left neighbour should always
        // get more candies than its left neighbour
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left2right[i] = left2right[i - 1] + 1;
            }
        }

        // The student with a higher rating than its right neighbour should always
        // get more candies than its right neighbour
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right2left[i] = right2left[i + 1] + 1;
            }
        }

        for (int i = 0; i < ratings.length; i++) {
            sum += Math.max(left2right[i], right2left[i]);
        }

        return sum;
    }
}
