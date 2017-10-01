package com.leetcode.problem;

import java.util.*;

/**
 * Remove Invalid Parentheses
 *
 * How to convert to a graph/tree search problem. BFS vs DFS
 *
 * https://discuss.leetcode.com/topic/28827/share-my-java-bfs-solution
 * The idea is straightforward, with the input string s, we generate all possible states by removing one ( or ),
 * check if they are valid, if found valid ones on the current level, put them to the final result list and we are done.
 * Otherwise, add them to a queue and carry on to the next level
 *
 * TODO: improve performance. investigate DFS solution.
 */
public class Problem301 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();

        // sanity check
        if (s == null) return res;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        // initialize
        queue.add(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {
            s = queue.poll();

            if (isValid(s)) {
                // found an answer, add to the result
                res.add(s);
                found = true;
            }

            /**
             * Do not put shorter strings into queue if valid string found. It's OK to already have some
             * strings shorter by 1 than valid strings because:
             * "For a string of parentheses to be valid, its number of parentheses should be even. And at any time,
             * strings in queue will only differ in length of 1 (this is the implicit control). For example, when we
             * find "()()" to be valid, both "()" and "" have not been added to queue yet and all the shorter strings
             * are of length of 3, which must be invalid." (https://discuss.leetcode.com/topic/28827/share-my-java-bfs-solution)
             */
            if (found) continue;

            // generate all possible states
            for (int i = 0; i < s.length(); i++) {
                // we only try to remove left or right paren
                if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;

                String t = s.substring(0, i) + s.substring(i + 1);

                if (!visited.contains(t)) {
                    // for each state, if it's not visited, add it to the queue
                    queue.add(t);
                    visited.add(t);
                }
            }
        }

        return res;
    }

    // helper function checks if string s contains valid parentheses
    boolean isValid(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') count++;
            if (c == ')' && count-- == 0) return false;
        }

        return count == 0;
    }
}
