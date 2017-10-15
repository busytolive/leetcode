package com.leetcode.problem;

import java.util.*;

/**
 * Sort Characters By Frequency
 *
 * counting & bucketing for integers in limited range
 */
public class Problem451 {
    public String frequencySort(String s) {
        int max = 0;
        int[] freq = new int[256]; // freq[i] is the count of char i (0 <= i <= 255)
        for (char i :s.toCharArray()) {
            freq[i]++;
            if (freq[i] > max) max = freq[i];
        }
        String[] bucket = new String[max + 1]; // bucket[i] contains characters with the same frequency i
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 0) continue;
            if (bucket[freq[i]] == null) bucket[freq[i]] = "";
            StringBuilder sb = new StringBuilder();
            for (int ii = 0; ii < freq[i]; ii++) {
                sb.append(String.valueOf((char)i));
            }
            bucket[freq[i]] = bucket[freq[i]] + sb.toString();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) sb.append(bucket[i]);
        }
        return sb.toString();
    }
}
