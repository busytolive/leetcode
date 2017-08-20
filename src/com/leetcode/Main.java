package com.leetcode;

import com.leetcode.library.ListNode;
import com.leetcode.problem.*;

public class Main {
    public static void main(String[] args) {
        for (String abbr: new Problem320().generateAbbreviations("word")) {
            System.out.println(abbr);
        }
    }
}
