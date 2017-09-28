package com.leetcode.problem;

import com.leetcode.library.Interval;

import java.util.Arrays;
import java.util.Stack;

/**
 * Meeting Rooms II
 *
 * Notes: we have meeting start events and end events. we need a meeting room for each
 * start event and release a meeting room for each end events.
 * TODO: improve performance.
 */
public class Problem253 {
    public int minMeetingRooms(Interval[] intervals) {
        int[][]events = new int[intervals.length * 2][2];
        for (int i = 0; i < intervals.length; i++) {
            events[i * 2] = new int[]{intervals[i].start, 0};
            events[i * 2 + 1] = new int[]{intervals[i].end, 1};
        }
        Arrays.sort(events, (event, another) -> {
            if (event[0] == another[0]) {
                return -1 * (event[1] - another[1]);
            } else {
                return event[0] - another[0];
            }
        });

        int currentInUse = 0;
        int maxRoomInUse = 0;
        for (int i = 0; i < events.length; i++) {
            if (events[i][1] == 0) {
                currentInUse++;
                if (currentInUse > maxRoomInUse) {
                    maxRoomInUse = currentInUse;
                }
            } else {
                currentInUse--;
            }
        }
        return maxRoomInUse;
    }
}
