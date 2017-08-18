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

    private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carryOnFromLow) {
        // node == null means all digits from list the node belongs to are added to sum
        if (l1 == null && l2 == null) {
            if (carryOnFromLow == 1) {
                return new ListNode(1);
            } else {
                return null;
            }
        }
        int operand1 = l1 == null ? 0 : l1.val;
        int operand2 = l2 == null ? 0 : l2.val;
        int sum = (operand1 + operand2 + carryOnFromLow) % 10;
        int carryOnToHigh = (operand1 + operand2 + carryOnFromLow) / 10;
        ListNode sumNode = new ListNode(sum);
        // keep calculating until l1 == null && l2 == null
        sumNode.next = addTwoNumbers(l1 == null ? null: l1.next, l2 == null ? null : l2.next, carryOnToHigh);
        return sumNode;
    }
}
