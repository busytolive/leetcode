package com.leetcode.problem;

import com.leetcode.library.ListNode;

/**
 * Delete Node in a Linked List
 */
public class Problem237 {
    public void deleteNode(ListNode node) {
        ListNode pre = node;
        while (node.next != null) {
            node.val = node.next.val;
            pre = node;
            node = node.next;
        }
        pre.next = null;
    }
}
