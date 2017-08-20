package com.leetcode.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * Moving Average from Data Stream
 */
public class Problem346 {
    private List<Integer> mStream;
    private int mWindowSize;
    private int mFirst;
    private int mLast;
    private double movingSum;

    /** Initialize your data structure here. */
    public Problem346(int size) {
        mWindowSize = size;
        mStream = new ArrayList<>();
        mFirst = 0;
        mLast = 0;
    }

    public double next(int val) {
        mStream.add(val);
        mLast = mStream.size() - 1;
        movingSum += val;
        if (mLast - mFirst + 1 > mWindowSize) { // need slide window
            movingSum -= mStream.get(mFirst);
            mFirst++;
        }
        return movingSum / (mLast - mFirst + 1);
    }
}
