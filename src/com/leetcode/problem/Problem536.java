package com.leetcode.problem;

import com.leetcode.library.TreeNode;

/**
 * Construct Binary Tree from String
 *
 * recursion code is easier to write
 */
public class Problem536 {
    public TreeNode str2tree(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }

        int firstParen = s.indexOf('(');
        int rootValue = firstParen == -1 ? Integer.parseInt(s) : Integer.parseInt(s.substring(0, firstParen));
        TreeNode root = new TreeNode(rootValue);
        if (firstParen == -1) { // do not have children
            return root;
        }

        int openParen = 0;
        for(int i = firstParen; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openParen++;
            }
            if (s.charAt(i) == ')') {
                openParen--;
            }
            if (openParen == 0) { //close parentheses found for left sub-tree
                root.left = str2tree(s.substring(firstParen + 1, i));
                if (i < s.length() - 1) { // have right sub-tree
                    root.right = str2tree(s.substring(i + 2, s.length() - 1));
                }
                break;
            }
        }
        return root;
    }
}

