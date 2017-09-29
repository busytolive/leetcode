package com.leetcode.problem;

import com.leetcode.library.Interval;

import java.util.Arrays;
import java.util.Stack;

/**
 * Meeting Rooms II
 *
 * Notes: we have meeting start events and end events. we need a meeting room for each
 * start event and release a meeting room for each end events.
 */
public class Problem253 {
    public int minMeetingRooms(Interval[] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i< intervals.length; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int currentRoomsInUse = 0;
        int maxRoomInUse = 0;
        int i = 0, j = 0;
        while(i < start.length) {
            // consume one meeting room
            while(i < start.length && start[i] < end[j]) {
                currentRoomsInUse++;
                i++;
            }
            if (currentRoomsInUse > maxRoomInUse) {
                maxRoomInUse = currentRoomsInUse;
            }

            // release one meeting room
            j++;
            currentRoomsInUse--;
        }
        return maxRoomInUse;
    }
}
