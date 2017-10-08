package com.leetcode.problem;

import com.leetcode.library.TreeLinkNode;

/**
 * Populating Next Right Pointers in Each Node
 *
 * BFS binary Tree with O(1) space.
 */
public class Problem116 {
    public void connect(TreeLinkNode root) {
        TreeLinkNode firstNodeInCurrentLevel = root;
        while (firstNodeInCurrentLevel != null) {
            TreeLinkNode current = firstNodeInCurrentLevel;
            // travel the current level, at the same time construct next pointers of node on next level
            while (current != null && current.left != null) {
                current.left.next = current.right;
                current.right.next = current.next == null ? null : current.next.left;
                current = current.next;
            }
            firstNodeInCurrentLevel = firstNodeInCurrentLevel.left;
        }
    }
}
