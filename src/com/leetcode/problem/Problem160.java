package com.leetcode.problem;

import com.leetcode.library.ListNode;

/**
 * Intersection of Two Linked Lists
 */
public class Problem160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int lengthB = 0;
        ListNode node = headB;
        while (node != null) {
            lengthB++;
            node = node.next;
        }

        int lengthA = 0;
        node = headA;
        while (node != null) {
            lengthA++;
            node = node.next;
        }

        ListNode indexA = headA, indexB = headB;
        if (lengthA > lengthB) {
            for (int i = 0; i < lengthA - lengthB; i++) {
                indexA = indexA.next;
            }
        } else {
            for (int i = 0; i < lengthB - lengthA; i++) {
                indexB = indexB.next;
            }
        }

        while (indexA != null && indexB != null) {
            if (indexA == indexB) {
                return indexA;
            }

            indexA = indexA.next;
            indexB = indexB.next;
        }

        return null;
    }
}
