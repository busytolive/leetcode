package com.leetcode;

import com.leetcode.library.Interval;
import com.leetcode.library.ListNode;
import com.leetcode.problem.*;

public class Main {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,3,1}, {1,5,1}, {4,2,1}};
        System.out.println(new Problem64().minPathSum(grid));
    }
}
