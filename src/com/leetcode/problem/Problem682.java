package com.leetcode.problem;

import java.util.Stack;

/**
 * Baseball Game
 *
 * Note: use stack to easily access the LAST inserted one or several elements
 */
public class Problem682 {
    public int calPoints(String[] ops) {
        Stack<String> stack = new Stack<>();
        for (String score: ops) {
            if (score.equals("+")) {
                int currentScore = Integer.parseInt(stack.get(stack.size() - 1)) + Integer.parseInt(stack.get(stack.size() - 2));
                stack.push(Integer.toString(currentScore));
            } else if (score.equals("D")) {
                stack.push(Integer.toString(Integer.parseInt(stack.peek()) * 2));
            } else if (score.equals("C")) {
                stack.pop();
            } else {
                stack.push(score);
            }
        }

        int sum = 0;
        for (String score: stack) {
            sum += Integer.parseInt(score);
        }

        return sum;
    }
}
