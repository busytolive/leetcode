package com.leetcode.problem;

/**
 * Shortest Word Distance
 */
public class Problem243 {
    public int shortestDistance(String[] words, String word1, String word2) {
        String lastFound = "";
        int lastIndex = 0;
        int shortest = words.length;
        for (int i = 0; i < words.length; i++) {
            // find word1 or word2
            while (i < words.length && !word1.equals(words[i]) && !word2.equals(words[i])) {
                i++;
            }

            if (i < words.length) { // word1 or word2 is found
                if (!lastFound.isEmpty() && !lastFound.equals(words[i])) { //only calculate distance if new found word is
                    // different than last found
                    if (i - lastIndex < shortest) {
                        shortest = i - lastIndex;
                    }
                }
                // update lastFound word and index
                lastFound = words[i];
                lastIndex = i;
            }
        }
        return shortest;
    }
}
