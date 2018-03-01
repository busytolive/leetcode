package com.leetcode.problem;

import com.leetcode.library.TreeNode;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Average of Levels in Binary Tree
 *
 * Use Queue(first in first out) to traverse a binary tree in level order. use a special node to separate
 * levels.
 */
public class Problem637 {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        nodes.add(null); // use a node with value null to mark end of a level
        List<Double> averageOfLevels = new ArrayList<>();
        while (nodes.size() > 0) { // loop all the nodes, iterate one level a time
            int numOfNodes = 0;
            double sumOfNodes = 0;
            TreeNode current = nodes.remove();
            if (current == null) { // no nodes in the current level, exit the loop
                break;
            }
            while(current != null) { // calculate average for current level
                numOfNodes++;
                sumOfNodes += current.val;
                if (current.left != null) {
                    nodes.add(current.left);
                }
                if (current.right != null) {
                    nodes.add(current.right);
                }
                current = nodes.poll();
            }
            averageOfLevels.add(sumOfNodes / numOfNodes);
            nodes.add(null); // since all nodes of next level are added to queue, add the null node to mark the end
            // of the next level
        }
        return averageOfLevels;
    }
}
