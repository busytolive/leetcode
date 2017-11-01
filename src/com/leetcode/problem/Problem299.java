package com.leetcode.problem;

/**
 * Bulls and Cows
 * since only contain digits, we can use int[256] instead of Map to count character, which is faster.
 */
public class Problem299 {
    public String getHint(String secret, String guess) {
        int[] secrets = new int[256];
        int[] guesses = new int[256];
        int bulls = 0, cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            char charOfSecret = secret.charAt(i);
            char charOfGuess = guess.charAt(i);
            if (charOfGuess == charOfSecret) {
                bulls++;
                continue;
            }

            if (secrets[charOfGuess] > 0) {
                secrets[charOfGuess]--;
                cows++;
            } else {
                guesses[charOfGuess]++;
            }

            if (guesses[charOfSecret] > 0) {
                guesses[charOfSecret]--;
                cows++;
            } else {
                secrets[charOfSecret]++;
            }
        }

        return Integer.toString(bulls) + "A" + Integer.toString(cows) + "B";
    }
}
