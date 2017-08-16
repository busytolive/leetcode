package com.leetcode.problem;

import com.leetcode.library.ListNode;

/**
 * Add Two Numbers
 *
 * Note: linked list, recursion
 */
public class Problem2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carryOn) {
        if (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carryOn;
            ListNode newNode = new ListNode(sum % 10);
            newNode.next = addTwoNumbers(l1.next, l2.next, sum / 10);
            return newNode;
        } else if (l1 != null) {
            ListNode curr = l1;
            while (true) {
                int sum = curr.val + carryOn;
                curr.val = sum % 10;
                carryOn = sum / 10;
                if (carryOn == 0) {
                    return l1;
                } else if (curr.next == null) {
                    ListNode newNode = new ListNode(1);
                    curr.next = newNode;
                    newNode.next = null;
                    return l1;
                } else {
                    curr = curr.next;
                }
            }
        } else if (l2 != null) {
            ListNode curr = l2;
            while (true) {
                int sum = curr.val + carryOn;
                curr.val = sum % 10;
                carryOn = sum / 10;
                if (carryOn == 0) {
                    return l2;
                } else if (curr.next == null) {
                    ListNode newNode = new ListNode(1);
                    curr.next = newNode;
                    newNode.next = null;
                    return l2;
                } else {
                    curr = curr.next;
                }
            }
        } else if (carryOn == 1) {
            return new ListNode(1);
        } else {
            return null;
        }
    }
}
