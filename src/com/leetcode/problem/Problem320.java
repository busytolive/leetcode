package com.leetcode.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * Generalized Abbreviation
 *
 * backtracking
 */
public class Problem320 {
    private boolean[] mAbbreviated;
    private List<String> mAbbreviations;
    private String mWord;

    public List<String> generateAbbreviations(String word) {
        // abbreviated[i] = true means the ith character is abbreviated with number
        mAbbreviated = new boolean[word.length()];
        mAbbreviations = new ArrayList<>();
        mWord = word;
        backtrack(-1);
        return mAbbreviations;
    }

    private void backtrack(int index) {
        // every node is a accepted solution
        mAbbreviations.add(getAbbreviation());

        // reach the leaf node
        if (index == mAbbreviated.length - 1) {
            return;
        }

        // get next node
        for (int i = index + 1; i < mAbbreviated.length && !mAbbreviated[i]; i++) {
            mAbbreviated[i] = true;
            backtrack(i);
            mAbbreviated[i] = false;
        }
    }

    private String getAbbreviation() {
        StringBuilder abbreviation = new StringBuilder();
        int count = 0;
        for (int i = 0; i < mAbbreviated.length; i++) {
            if (!mAbbreviated[i]) {
                abbreviation.append(mWord.charAt(i));
            } else {
                count++;
                if (i == mAbbreviated.length - 1 || !mAbbreviated[i + 1]) {
                    abbreviation.append(count);
                    count = 0;
                }
            }
        }
        return abbreviation.toString();
    }
}
