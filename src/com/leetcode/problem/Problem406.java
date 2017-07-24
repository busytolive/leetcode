package com.leetcode.problem;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Queue Reconstruction by Height
 */
public class Problem406 {
    private int peopleNum;
    private final int defaultHeight = -1;

    public int[][] reconstructQueue(int[][] people) {
        peopleNum = people.length;
        int[][] reconstructedQueue = getEmptyReconstructedQueue();

        sortByHeightAscend(people);

        for (int i = 0; i < peopleNum; i++) {
            int[] person = people[i];
            int height = person[0];
            int totalNumberOfHigherPersonAhead = person[1];
            int currentNumberOfHigherPersonAhead = 0;
            int index = 0;
            while (index < peopleNum) {
                // does not count lower people
                if (reconstructedQueue[index][0] != defaultHeight && reconstructedQueue[index][0] < height) {
                    index++;
                    continue;
                }

                if (currentNumberOfHigherPersonAhead == totalNumberOfHigherPersonAhead) {
                    break;
                }

                index++;
                currentNumberOfHigherPersonAhead++;
            }

            reconstructedQueue[index][0] = height;
            reconstructedQueue[index][1] = totalNumberOfHigherPersonAhead;
        }

        return reconstructedQueue;
    }

    private int[][] getEmptyReconstructedQueue() {
        int[][] reconstructedQueue = new int[peopleNum][2];
        for (int[] person : reconstructedQueue) {
            Arrays.fill(person, defaultHeight);
        }
        return reconstructedQueue;
    }

    private void sortByHeightAscend(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] person, int[] anotherPerson) {
                return person[0] - anotherPerson[0];
            }
        });
    }
}
