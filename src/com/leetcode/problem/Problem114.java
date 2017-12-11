package com.leetcode.problem;

import com.leetcode.library.TreeNode;

/**
 * Flatten Binary Tree to Linked List
 *
 * Note: store the next node in pre-order traversal for the current sub-tree
 */
public class Problem114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root, null);
    }

    private void flatten(TreeNode root, TreeNode next) {
        if (root.left == null && root.right == null) {
            root.right = next;
            return;
        }

        if (root.left != null) {
            if (root.right != null) {
                flatten(root.left, root.right);
                flatten(root.right, next);
            } else {
                flatten(root.left, next);
            }
            root.right = root.left;
            root.left = null;
        } else {
            flatten(root.right, next);
        }
    }
}
