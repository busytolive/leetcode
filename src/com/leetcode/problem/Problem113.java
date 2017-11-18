package com.leetcode.problem;

import com.leetcode.library.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Path Sum II
 *
 * Recursion. Be careful about when to give direct answer with recursion.
 */
public class Problem113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        // return empty list for a empty tree
        if (root == null) {
            return new LinkedList<>();
        }

        // return [[root]] for single-node tree if root.val == sum
        if (root.left == null && root.right == null) {
            if(root.val == sum) {
                List<Integer> path = new LinkedList<>();
                path.add(root.val);
                List<List<Integer>> paths = new LinkedList<>();
                paths.add(path);
                return paths;
            }
            return new LinkedList<>();
        }

        List<List<Integer>> paths = new LinkedList<>();
        if (root.left != null) {
            List<List<Integer>> leftPaths = pathSum(root.left, sum - root.val);
            for (List<Integer> leftPath:
                 leftPaths) {
                leftPath.add(0, root.val);
                paths.add(leftPath);
            }
        }

        if (root.right != null) {
            List<List<Integer>> rightPaths = pathSum(root.right, sum - root.val);
            for (List<Integer> rightPath:
                 rightPaths) {
                rightPath.add(0, root.val);
                paths.add(rightPath);
            }
        }
        return paths;
    }
}
