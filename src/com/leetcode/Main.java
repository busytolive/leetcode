package com.leetcode;

import com.leetcode.library.ListNode;
import com.leetcode.problem.*;

public class Main {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        Problem2 problem2 = new Problem2();
        ListNode sum = problem2.addTwoNumbers(l1, l2);

        ListNode curr = sum;
        while (curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
    }
}
