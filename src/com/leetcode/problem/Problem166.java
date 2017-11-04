package com.leetcode.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * Fraction to Recurring Decimal
 *
 * Java integer overflow: long vs int
 *
 * The key insight here is to notice that once the remainder starts repeating, so does the divided result.
 */
public class Problem166 {
    public String fractionToDecimal(int numerator, int denominator) {

        long new_numerator = numerator;
        long new_denominator = denominator;

        Map<Long, Integer> remainders = new HashMap<>();

        // result is integer
        if (new_numerator % new_denominator == 0) {
            return Long.toString(new_numerator / new_denominator);
        }

        StringBuilder builder = new StringBuilder();
        if ((new_numerator ^ new_denominator & 0x80000000) < 0) {
            builder.append('-');
            new_numerator *= -1;
        }

        new_numerator = Math.abs(new_numerator);
        new_denominator = Math.abs(new_denominator);

        if (new_numerator / new_denominator == 0) {
            builder.append(0);
        } else {
            while (new_numerator / new_denominator > 0) {
                builder.append(new_numerator / new_denominator);
                new_numerator %= new_denominator;
            }
        }
        builder.append('.');

        long remainder = new_numerator;
        while (!remainders.containsKey(remainder)) {
            remainders.put(remainder, builder.length());
            builder.append(remainder * 10 / new_denominator);
            remainder = remainder * 10 % new_denominator;
            if (remainder == 0) {
                return builder.toString();
            }
        }

        builder.insert(remainders.get(remainder), "(");
        builder.append(")");

        return builder.toString();
    }
}
