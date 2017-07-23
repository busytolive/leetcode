package com.leetcode.problem;

/**
 * Student Attendance Record I
 */
public class Problem551 {
    public boolean checkRecord(String s) {
        int numOfContinuousL = 0;
        int numOfA = 0;

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (current == 'L') {
                numOfContinuousL++;
            } else {
                numOfContinuousL = 0;

                if (current == 'A') {
                    numOfA++;
                }
            }

            if (numOfA > 1 || numOfContinuousL > 2) {
                return false;
            }
        }

        return true;
    }
}
