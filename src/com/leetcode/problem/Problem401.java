package com.leetcode.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Watch
 */
public class Problem401 {
    private List<String> times = new ArrayList<>();
    private int totalNum;
    private int lights;

    public List<String> readBinaryWatch(int num) {
        totalNum = num;
        backtrack(0, 0);
        return times;
    }

    private void backtrack(int n, int i) {
        if (getHour() > 11 || getMinute() > 59) {
            return; // prune
        }

        if (n == totalNum) {
            times.add(display()); // print a solution
            return;
        }

        for (int j = i; j < 11; j++) {
            if ((lights & 0x1 <<j) == 0) {
                int temp = lights;
                lights |= 0x1 << j;
                backtrack(n + 1, j + 1);
                lights = temp;
            }
        }
    }

    private String display() {
        int hour = getHour();
        int minute = getMinute();
        return Integer.toString(hour) + ":" +
                (minute < 10 ? "0" + Integer.toString(minute) : Integer.toString(minute));
    }

    private int getHour() {
        return (lights & 0xffffffc0) >> 6;
    }

    private int getMinute() {
        return lights & 0x3f;
    }
}
