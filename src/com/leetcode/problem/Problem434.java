package com.leetcode.problem;

/**
 * Number of Segments in a String
 *
 * Note: String.trim(): remove leading and trailing spaces of a string
 *       String.split: split a string by regex.
 */
public class Problem434 {
    public int countSegments(String s) {
        String trimmed = s.trim();
        if (trimmed.isEmpty()) {
            return 0;
        }
        return trimmed.split("\\s+").length;
    }
}
