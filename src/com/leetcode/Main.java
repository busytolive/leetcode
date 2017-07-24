package com.leetcode;

import com.leetcode.problem.Problem406;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[][] reconstructed = new Problem406().reconstructQueue(new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}});
        System.out.println(Arrays.deepToString(reconstructed));
    }
}
