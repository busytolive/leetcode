package com.leetcode.problem;

import com.leetcode.library.TreeNode;

/**
 * Sum of Left Leaves
 */
public class Problem404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        TreeNode leftChild = root.left, rightChild = root.right;

        if (leftChild != null) {
            if (leaf(leftChild)) {
                sum += leftChild.val;
            } else {
                sum += sumOfLeftLeaves(leftChild);
            }
        }

        if (rightChild != null) {
            sum += sumOfLeftLeaves(rightChild);
        }

        return sum;
    }

    private boolean leaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
