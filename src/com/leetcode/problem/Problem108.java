package com.leetcode.problem;

import com.leetcode.library.TreeNode;

/**
 * Convert Sorted Array to Binary Search Tree
 *
 * Divide-and-conquer
 */
public class Problem108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        return convert(nums, 0, nums.length - 1);
    }

    private TreeNode convert(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        if (left == right) {
            return new TreeNode(nums[left]);
        }

        int middle = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = convert(nums, left, middle - 1);
        root.right = convert(nums, middle + 1, right);
        return root;
    }
}
