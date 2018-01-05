package com.leetcode.problem;

import java.util.List;

public class Problem422 {
    public boolean validWordSquare(List<String> words) {
        if (words == null || words.size() == 0) {
            return true;
        }

        int row = words.size();
        int col = words.get(0).length();
        for (int i = 1; i < row; i++) {
            if (words.get(i).length() > col) {
                col = words.get(i).length();
            }
        }
        if (row != col) {
            return false;
        }
        int size = row;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (j >= words.get(i).length() && i < words.get(j).length()) {
                    return false;
                }
                if (j < words.get(i).length() && i >= words.get(j).length()) {
                    return false;
                }
                if (j < words.get(i).length() && i < words.get(j).length() && words.get(i).charAt(j) != words.get(j).charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
