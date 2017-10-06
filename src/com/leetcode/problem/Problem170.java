package com.leetcode.problem;

import java.util.*;

/**
 * Data structure design
 *
 * Only store unique numbers to reduce find time: O(n), n = list size
 */
public class Problem170 {
    private List<Integer> uniqueNumbers = new ArrayList<>();
    private Map<Integer, Integer> count = new HashMap<>();

    public void add(int number) {
        if (count.containsKey(number)) count.put(number, count.get(number) + 1);
        else {
            count.put(number, 1);
            uniqueNumbers.add(number);
        }
    }

    public boolean find(int value) {
        for (int i = 0; i < uniqueNumbers.size(); i++) {
            int num1 = uniqueNumbers.get(i), num2 = value - num1;
            if ((num1 == num2 && count.get(num1) > 1) || (num1 != num2 && count.containsKey(num2))) {
                return true;
            }
        }
        return false;
    }
}

