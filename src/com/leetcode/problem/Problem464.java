package com.leetcode.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * Can I Win
 *
 * Note: revisit the backtrack logic
 */
public class Problem464 {

    Map<Integer, Boolean> result;
    boolean[] used;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) {
            return true;
        }

        int sum = (1 + maxChoosableInteger)*maxChoosableInteger / 2;
        if (desiredTotal > sum) {
            return false;
        }

        result = new HashMap<>();
        used = new boolean[maxChoosableInteger + 1]; // used[i] indicate if integer i is used
        return backtrack(desiredTotal);
    }

    // return false if whatever integer is chosen will lose.
    // Otherwise, there is at least one integer if chosen can force a win
    private boolean backtrack(int desiredTotal) {
        if (desiredTotal <= 0) {
            return false;
        }

        int key = getKeyOfResultCache(used);
        if (!result.containsKey(key)) {
            for (int i = 1; i < used.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    if (!backtrack(desiredTotal - i)) { // opponent always loose if choose i
                        result.put(key, true);
                        used[i] = false;
                        return true;
                    }
                    used[i] = false;
                }
            }
            result.put(key, false);
        }
        return result.get(key);
    }

    private int getKeyOfResultCache(boolean[] used) {
        int key = 0;
        for (boolean integerUsed : used) {
            key <<= 1;
            if (integerUsed) {
                key |= 1;
            }
        }
        return key;
    }
}