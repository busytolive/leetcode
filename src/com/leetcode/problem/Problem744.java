package com.leetcode.problem;

public class Problem744 {
    public char nextGreatestLetter(char[] letters, char target) {
        char result = nextGreatestLetterRange(letters, target, 0, letters.length - 1);
        return result == ' ' ? letters[0] : result;
    }

    private char nextGreatestLetterRange(char[] letters, char target, int start, int end) {
        if (start > end) {
            return ' ';
        }

        int mid = start + (end - start) / 2;
        if (letters[mid] > target) {
            char smaller = nextGreatestLetterRange(letters, target, start, mid - 1);
            if (smaller == ' ') {
                return letters[mid];
            } else {
                return smaller;
            }
        } else {
            return nextGreatestLetterRange(letters, target, mid + 1, end);
        }
    }
}
