package com.leetcode;

import com.leetcode.library.ListNode;
import com.leetcode.problem.*;

public class Main {
    public static void main(String[] args) {
        Problem460 cache = new Problem460( 0 /* capacity */ );
        cache.put(0, 0);
        cache.get(0);       // returns 1
    }
}
