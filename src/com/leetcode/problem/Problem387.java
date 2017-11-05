package com.leetcode.problem;

/**
 * First Unique Character in a String
 * HashTable: character as key
 */
public class Problem387 {
    public int firstUniqChar(String s) {
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)] == 1) {
                return i;
            }
        }

        return -1;
    }
}
