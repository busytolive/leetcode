package com.leetcode.problem;

import com.leetcode.library.TreeNode;

/**
 * Symmetric Tree
 *
 * Recursion
 */
public class Problem101 {
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        return  left == null && right == null ||
                left != null && right != null && left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
