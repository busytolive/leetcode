package com.leetcode.problem;

/**
 * Reverse String
 */
public class Problem344 {
    public String reverseString(String s) {
        StringBuilder reversed = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed.append(s.charAt(i));
        }
        return reversed.toString();
    }
}
