package com.leetcode;

import com.leetcode.library.Interval;
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
    //    System.out.println(cache.get(4));       // returns
        Problem604 iterator = new Problem604("L1e2t1C1o1d1e1");

        System.out.println(iterator.next()); // return 'L'
        System.out.println(iterator.next()); // return 'e'
        System.out.println(iterator.next()); // return 'e'
        System.out.println(iterator.next()); // return 't'
        System.out.println(iterator.next()); // return 'C'
        System.out.println(iterator.next()); // return 'o'
        System.out.println(iterator.next()); // return 'd'
        System.out.println(iterator.hasNext()); // return true
        System.out.println(iterator.next()); // return 'e'
        System.out.println(iterator.hasNext()); // return false
        System.out.println(iterator.next()); // return ' '
    }
}
