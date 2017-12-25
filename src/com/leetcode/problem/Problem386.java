package com.leetcode.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * Lexicographical Numbers
 */
public class Problem386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>(n);
        int curr = 1;
        for (int i = 1; i <= n; i++) {
            result.add(curr);
            curr = nextInLexicalOrder(curr, n);
        }
        return result;
    }

    private int nextInLexicalOrder(int curr, int n) {
        if (curr * 10 <= n) { // case 1: 12 -> 120
            curr *= 10;
        } else if (curr % 10 != 9 && curr + 1 <= n) { // case 2: 12 -> 13
            curr++;
        } else {
            while ((curr / 10) % 10 == 9) { // case 3: 12 or 19 or 199 -> 20
                curr /= 10;
            }
            curr = curr / 10 + 1;
        }
        return curr;
    }
}
