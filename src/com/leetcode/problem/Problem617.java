package com.leetcode.problem;

import com.leetcode.library.TreeNode;

/**
 * Merge Two Binary Trees
 *
 * binary tree, recursive
 */
public class Problem617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }

        if (t1 == null) {
            return t2;
        }

        if (t2 == null) {
            return t1;
        }

        TreeNode newNode = new TreeNode(t1.val + t2.val);
        newNode.left = mergeTrees(t1.left, t2.left);
        newNode.right = mergeTrees(t1.right, t2.right);
        return newNode;
    }
}
