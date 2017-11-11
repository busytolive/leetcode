package com.leetcode.problem;

import com.leetcode.library.ListNode;

import java.util.Random;

/**
 * Linked List Random Node
 *
 * Reservoir Sampling Algorithm: randomly select k elements from n elements, (n could be very huge)
 *
 * Solution: https://leetcode.com/problems/linked-list-random-node/discuss/
 * key point of Proof: for any step i, the probability of each element from 1 to k+i to be selected is k/k+i.
 * （用数学归纳法证明: i = 1 成立； 假设 i = m 成立，证明 i = m + 1 时成立）
 *
 * This problem is a special case when k = 1
 */
public class Problem382 {

    ListNode mHead;
    Random mRandom;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Problem382(ListNode head) {
        mHead = head;
        mRandom = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int selected = mHead.val;
        ListNode node = mHead.next;
        int i = 1;
        while (node != null) {
            int select = mRandom.nextInt(i + 1); // return randomly between [0, i]
            if (select == 0) { // the probability to return 0 is 1/i+1
                selected = node.val;
            }
            node = node.next;
            i++;
        }
        return selected;
    }
}
