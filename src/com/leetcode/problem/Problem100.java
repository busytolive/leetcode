package com.leetcode.problem;

import com.leetcode.library.TreeNode;

/**
 * Same Tree
 *
 * Recursion, binary tree
 */
public class Problem100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        return p != null && q != null && p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
