package com.leetcode.problem;

/**
 * Reverse String II
 *
 * use StringBuilder to reverse String
 */
public class Problem541 {
    public String reverseStr(String s, int k) {
        StringBuilder result = new StringBuilder();
        boolean even = true;
        for (int i = 0; i < s.length(); i = i + k) {
            StringBuilder group = i + k < s.length() ? new StringBuilder(s.substring(i, i + k)) : new StringBuilder(s.substring(i));
            if (even) {
                result.append(group.reverse());
                even = false;
            } else {
                result.append(group.toString());
                even = true;
            }
        }

        return result.toString();
    }
}
