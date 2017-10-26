package com.leetcode.problem;

import com.leetcode.library.ListNode;

/**
 * Odd Even Linked List
 */
public class Problem328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddHead = head, oddTail = head, evenHead = head.next, evenTail = head.next;
        ListNode curr = head.next.next; int i = 3;
        while(curr != null) {
            if (i % 2 == 1) {
                oddTail.next = curr;
                oddTail = curr;
            } else {
                evenTail.next = curr;
                evenTail = curr;
            }
            i++;
            curr = curr.next;
        }
        oddTail.next = evenHead;
        evenTail.next = null;
        return oddHead;
    }
}
