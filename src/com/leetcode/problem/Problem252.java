package com.leetcode.problem;

import com.leetcode.library.Interval;

import java.util.Arrays;

/**
 * Meeting Rooms
 *
 * sort, custom sort with lambda expression
 */
public class Problem252 {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals.length < 2) {
            return true;
        }
        Arrays.sort(intervals, (interval, anotherInterval) -> (interval.start - anotherInterval.start));
        for(int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i + 1].start < intervals[i].end) {
                return false;
            }
        }
        return true;
    }
}
