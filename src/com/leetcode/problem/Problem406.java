package com.leetcode.problem;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Queue Reconstruction by Height
 */
public class Problem406 {
    public int[][] reconstructQueue(int[][] people) {
        final int EMPTY = -1;
        final int peopleNum = people.length;
        int[][] reconstructedQueue = new int[peopleNum][2];

        for (int[] person : reconstructedQueue) {
            Arrays.fill(person, EMPTY);
        }

        Arrays.sort(people, new PersonComparator());

        for(int i = 0; i < peopleNum; i++) {
            int[] person = people[i];
            int height = person[0];
            int numberOfHigherPersonAhead = person[1], currentNumberOfHigherPersonAhead = 0;

            int index = 0;
            while (index < peopleNum) {
                if (reconstructedQueue[index][0] != EMPTY && reconstructedQueue[index][0] < height) {
                    index++;
                    continue;
                }

                if (currentNumberOfHigherPersonAhead == numberOfHigherPersonAhead) {
                    break;
                }

                index++;
                currentNumberOfHigherPersonAhead++;
            }

            reconstructedQueue[index][0] = height;
            reconstructedQueue[index][1] = numberOfHigherPersonAhead;
        }

        return reconstructedQueue;

    }

    private static class PersonComparator implements Comparator<int[]>
    {
        public int compare(int[] person, int[] anotherPerson)
        {
            return person[0] - anotherPerson[0];
        }
    }
}
