package com.leetcode.problem;

import java.util.Arrays;
import java.util.Comparator;

import static java.lang.Math.max;

/**
 * Candy
 */
public class Problem135 {
    private static int[] mRatings;

    public int candy(int[] ratings) {
        mRatings = ratings;
        final int numOfChildren = ratings.length;
        int numOfCandies = 0;

        int candies[] = new int[numOfChildren];
        for (int i = 0; i < numOfChildren; i++) {
            candies[i] = 1;
        }

        final Integer[] indexs = getIndexListSortedByRating(ratings);
        for (int i = 0; i < numOfChildren; i++) {
            final int EMPTY = -1;
            int index = indexs[i];
            int rating = ratings[index];
            int leftRating = EMPTY;
            int rightRating = EMPTY;

            if (index - 1 >= 0) {
                leftRating = ratings[index - 1];
            }
            if (index + 1 < numOfChildren) {
                rightRating = ratings[index + 1];
            }

            if (leftRating != EMPTY && rightRating != EMPTY) {
                if (leftRating > rightRating) {
                    if (rating > leftRating) {
                        //candies[index] = candies[index - 1] + 1;
                        candies[index] = max(candies[index - 1] + 1, candies[index + 1] + 1);
                    } else if (rating > rightRating) {
                        candies[index] = candies[index + 1] + 1;
                    }
                } else {
                    if (rating > rightRating) {
                        //candies[index] = candies[index + 1] + 1;
                        candies[index] = max(candies[index - 1] + 1, candies[index + 1] + 1);
                    } else if (rating > leftRating) {
                        candies[index] = candies[index - 1] + 1;
                    }
                }
            } else if (leftRating != EMPTY && rating > leftRating) {
                candies[index] = candies[index - 1] + 1;
            } else if (rightRating != EMPTY && rating > rightRating) {
                candies[index] = candies[index + 1] + 1;
            }
        }

        for (int i = 0; i < numOfChildren; i++) {
            numOfCandies += candies[i];
        }

        return numOfCandies;
    }

    Integer[] getIndexListSortedByRating(int[] ratings) {
        Integer[] indexes = new Integer[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            indexes[i] = i;
        }
        Arrays.sort(indexes, new IndexComparator());
        return indexes;
    }

    private static class IndexComparator implements Comparator<Integer>
    {
        public int compare(Integer index, Integer anotherIndex)
        {
            return  mRatings[index] - mRatings[anotherIndex];
        }
    }
}
