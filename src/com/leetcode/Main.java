package com.leetcode;

import com.leetcode.library.ListNode;
import com.leetcode.problem.*;

public class Main {
    public static void main(String[] args) {
    //    Problem460 cache = new Problem460( 2 /* capacity */ );
    //    cache.put(1, 1);
    //    cache.put(2, 2);
    //    System.out.println(cache.get(1));       // returns 1
    //    cache.put(3, 3);    // evicts key 2
    //    System.out.println(cache.get(2));       // returns -1 (not found)
    //    System.out.println(cache.get(3));       // returns 3.
    //    cache.put(4, 4);    // evicts key 1.
    //    System.out.println(cache.get(1));       // returns -1 (not found)
    //    System.out.println(cache.get(3));       // returns 3
    //    System.out.println(cache.get(4));       // returns 4
        int[][] dungeon = new int[][] {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        System.out.println(new Problem174().calculateMinimumHP(dungeon));
    }
}
