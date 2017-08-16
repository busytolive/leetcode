package com.leetcode.problem;

import java.util.PriorityQueue;

/**
 * Kth Largest Element in an Array
 *
 * MinHeap, PriorityQueue
 */
public class Problem215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k + 1);
        for (int i : nums) {
            minHeap.offer(i);
            if (minHeap.size() > k) { // make sure heap size is no larger than k
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
