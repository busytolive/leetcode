package com.leetcode.problem;

import com.leetcode.library.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Binary Tree Level Order Traversal II
 *
 * List.add(0, element) : insert a element at the head of a list.
 */
public class Problem107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) {
            return new LinkedList<>();
        }

        List<List<Integer>> result = new LinkedList<>();
        List<TreeNode> currentLevel = new LinkedList<>();
        currentLevel.add(root);
        while(currentLevel.size() > 0) {
            List<TreeNode> nextLevel = new LinkedList<>();
            List<Integer> values = new LinkedList<>();
            for (TreeNode node:
                 currentLevel) {
                values.add(node.val);
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            result.add(0, values);
            currentLevel = nextLevel;
        }
        return result;
    }
}
