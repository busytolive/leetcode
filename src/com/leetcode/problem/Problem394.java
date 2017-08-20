package com.leetcode.problem;

import java.util.Stack;

/**
 * Decode String
 *
 * Stack(of "function invocation"), StringBuilder
 */
public class Problem394 {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder decoded = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char next = s.charAt(i);
            if (next != ']') {
                stack.push(next);
                continue;
            }

            StringBuilder stringToRepeat = new StringBuilder();
            char charToRepeat;
            StringBuilder repeatTimeString = new StringBuilder();
            int repeatTime;

            while((charToRepeat = stack.pop()) != '[') {
                stringToRepeat.append(charToRepeat);
            }
            stringToRepeat.reverse();
            while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
                repeatTimeString.append(stack.pop());
            }
            repeatTimeString.reverse();
            repeatTime = Integer.valueOf(repeatTimeString.toString());
            for(int j = 0; j < repeatTime; j++) {
                for (char repeated: stringToRepeat.toString().toCharArray()) {
                    stack.push(repeated);
                }
            }
        }

        for (char decodedChar: stack) {
            decoded.append(decodedChar);
        }
        return decoded.toString();
    }
}
