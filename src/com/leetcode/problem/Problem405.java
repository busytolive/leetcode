package com.leetcode.problem;

/**
 * Convert a Number to Hexadecimal
 *
 * Note: Bit manipulation, StringBuilder.reverse()
 */
public class Problem405 {
    public String toHex(int num) {
        StringBuilder hex = new StringBuilder();
        char[] dec2Hex = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        for (int i = 0; i < 8; i++) {
            hex.append(dec2Hex[num & 15]);
            num = num >>> 4;
            if (num == 0) {
                break;
            }
        }
        return hex.reverse().toString();
    }
}
