package com.leetcode.problem;

import com.leetcode.library.ListNode;

/**
 * Reverse Linked List
 */
public class Problem206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) { // base case: empty list or single node list
            return head;
        }

        ListNode reverseListHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return reverseListHead;
    }
}
