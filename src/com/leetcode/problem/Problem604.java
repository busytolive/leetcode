package com.leetcode.problem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Design Compressed String Iterator
 *
 * Queue
 */
public class Problem604 {
    Queue<int[]> queue = new LinkedList<>();

    public Problem604(String compressedString) {
        int i, j;
        for (i = 0; i < compressedString.length() - 1; i = j) {
            j = i + 1;
            while(j < compressedString.length() && compressedString.charAt(j) < 'A') {
                j++;
            }
            int[] item = new int[]{compressedString.charAt(i), Integer.parseInt(compressedString.substring(i + 1, j))};
            queue.add(item);
        }
    }

    public char next() {
        if (!hasNext()) {
            return ' ';
        }

        char ch;
        int[] head = queue.peek();
        ch = (char)head[0];
        int count = head[1];
        if (count > 1) {
            head[1] = count - 1;
        } else {
            queue.poll();
        }
        return ch;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
