package com.leetcode.problem;

import com.leetcode.library.ListNode;

/**
 * Partition List
 */
public class Problem86 {
    public ListNode partition(ListNode head, int x) {
        ListNode lessTail = null, lessHead = null, greaterHead = null, greaterTail = null;
        while (head != null) {
            int currValue = head.val;
            if (currValue < x) {
                if (lessHead == null) {
                    lessHead = head;
                }
                if (lessTail != null) {
                    lessTail.next = head;
                }
                lessTail = head;
            } else {
                if (greaterHead == null) {
                    greaterHead = head;
                }
                if (greaterTail != null) {
                    greaterTail.next = head;
                }
                greaterTail = head;
            }
            head = head.next;
        }

        if (lessTail != null) {
            lessTail.next = null;
        }

        if (greaterTail != null) {
            greaterTail.next = null;
        }

        if (lessHead == null) {
            return greaterHead;
        }

        lessTail.next = greaterHead;
        return lessHead;
    }
}
