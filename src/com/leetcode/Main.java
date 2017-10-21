package com.leetcode;

import com.leetcode.library.Interval;
import com.leetcode.library.ListNode;
import com.leetcode.problem.*;

public class Main {
    public static void main(String[] args) {
        Problem631 excel = new Problem631(3, 'C');
        excel.sum(1, 'A', new String[]{"A2"});
        excel.set(2, 'A', 1);
        excel.get(1, 'A');
    }
}
