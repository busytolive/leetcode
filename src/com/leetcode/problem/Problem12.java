package com.leetcode.problem;

/**
 * Integer to Roman
 */
public class Problem12{
    public String intToRoman(int num) {
        String[] thousands = new String[] {"", "M", "MM", "MMM"};
        String[] hundreds = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        int thousand = num / 1000;
        int hundred = num % 1000 / 100;
        int ten = num % 100 / 10;
        int one = num % 10;

        return thousands[thousand] + hundreds[hundred] + tens[ten] + ones[one];
    }
}
