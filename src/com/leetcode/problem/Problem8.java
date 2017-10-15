package com.leetcode.problem;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String to Integer (atoi)
 *
 * use double to store a possible very large number without loss of accuracy of integer(64 bit)
 */
public class Problem8 {
    public int myAtoi(String str) {
        Matcher matcher = Pattern.compile("\\s*([-|+]?)(\\d+).*").matcher(str);
        if(!matcher.matches()) {
            return 0;
        }

        String sign = matcher.group(1);
        String absStr = matcher.group(2);

        double abs = 0;
        double weight = 1;
        for (int i = absStr.length() - 1; i >= 0; i--) {
            abs += (absStr.charAt(i) - 48) * weight;
            weight *= 10;
        }

        if(sign.equals("-") && abs > 2147483648d) {
            return Integer.MIN_VALUE;
        } else if (!sign.equals("-") && abs > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return (int)(abs * (sign.equals("-") ? -1 : 1));
        }
    }
}
