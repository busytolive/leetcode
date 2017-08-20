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
        for (int i = 0; i < s.length(); i++) {
            char next = s.charAt(i);
            if (next != ']') {
                stack.push(next);
                continue;
            }

            StringBuilder stringToRepeat = new StringBuilder();
            char charToRepeat;
            while((charToRepeat = stack.pop()) != '[') {
                stringToRepeat.append(charToRepeat);
            }
            stringToRepeat.reverse();

            StringBuilder timeString = new StringBuilder();
            while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
                timeString.append(stack.pop());
            }
            timeString.reverse();
            int time = Integer.valueOf(timeString.toString());
            for(int j = 0; j < time; j++) {
                for (char decoded: stringToRepeat.toString().toCharArray()) {
                    stack.push(decoded);
                }
            }
        }

        StringBuilder decoded = new StringBuilder();
        for (char decodedChar: stack) {
            decoded.append(decodedChar);
        }
        return decoded.toString();
    }
}
