package com.leetcode.problem;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Valid Parentheses
 *
 * Stack
 *
 * 1. stack is empty at first
 * 2. Put a character into stack if not matched with top
 * 3. pop the top if match
 * 4. return valid of stack is empty at the end
 */
public class Problem20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch: s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(ch);
                continue;
            }

            char top = stack.peek();
            if (top == '[' && ch == ']' ||
                    top == '(' && ch == ')' ||
                    top == '{' && ch == '}') {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
