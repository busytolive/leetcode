package com.leetcode.problem;

import com.leetcode.library.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }

        if (root.left == null && root.right == null) {
            paths.add(Integer.toString(root.val));
        }

        List<String> leftPaths = binaryTreePaths(root.left);
        for (String path: leftPaths
                ) {
            paths.add(Integer.toString(root.val) + "->" + path);
        }

        List<String> rightPaths = binaryTreePaths(root.right);
        for (String path: rightPaths
                ) {
            paths.add(Integer.toString(root.val) + "->" + path);
        }

        return paths;
    }
}
