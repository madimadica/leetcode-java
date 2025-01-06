package com.madimadica.leetcode;

/**
 * <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/">19. Remove Nth Node From End of List</a>
 * <p>
 *     Medium
 * </p>
 * <p>
 *    0 ms - Beats 100.00%
 * </p>
 */
public class Problem19_RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        ListNode lag = head;

        for (int i = 0; i < n; ++i) {
            current = current.next;
        }
        if (current == null) {
            return head.next;
        }

        while (current.next != null) {
            lag = lag.next;
            current = current.next;
        }
        ListNode target = lag.next;
        lag.next = target == null ? null : target.next;
        return head;
    }

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
