package com.madimadica.leetcode;

import com.madimadica.leetcode.api.ListNode;

/**
 * <a href="https://leetcode.com/problems/swap-nodes-in-pairs/">24. Swap Nodes in Pairs</a>
 * <p>
 *     Medium
 * </p>
 * <p>
 *    0 ms - Beats 100.00%
 * </p>
 */
public class Problem24_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;

        while (current != null && current.next != null) {
            ListNode a = current;
            ListNode b = a.next;
            ListNode c = b.next;

            // [prev -> a -> b -> c] to [prev -> b -> a -> c]
            b.next = a;
            a.next = c;
            prev.next = b;

            prev = a;
            current = c;
        }
        return dummy.next;
    }
}
