package com.madimadica.leetcode;

import com.madimadica.leetcode.api.ListNode;

/**
 * <a href="https://leetcode.com/problems/add-two-numbers/description/">2. Add Two Numbers</a>
 * <p>
 *     Medium
 * </p>
 * <p>
 *     1 ms - Beats 100.00%
 * </p>
 * <p>
 *     This solution walks both lists in-sync and adds the current column to the output list, maintaining a carry value.
 * </p>
 */
public class Problem2_AddTwoNumbers {

    /**
     * <p>
     *     You are given two non-empty linked lists representing two non-negative integers.
     *     The digits are stored in reverse order, and each of their nodes contains a single digit.
     *     Add the two numbers and return the sum as a linked list.
     * </p>
     * <p>
     *     You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     * </p>
     *
     * @param l1 Linked list of addend 1
     * @param l2 linked list of addend 2
     * @return l1 + l2 as a listed list
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumHead = null;
        ListNode sumTail = null;

        ListNode current1 = l1;
        ListNode current2 = l2;
        int carry = 0;

        while (current1 != null || current2 != null) {
            int d1 = 0;
            int d2 = 0;
            if (current1 != null) {
                d1 = current1.val;
                current1 = current1.next;
            }
            if (current2 != null) {
                d2 = current2.val;
                current2 = current2.next;
            }
            int partialSum = d1 + d2 + carry;
            if (partialSum >= 10) {
                carry = 1;
                partialSum -= 10;
            } else {
                carry = 0;
            }
            if (sumHead == null) {
                sumHead = new ListNode(partialSum);
                sumTail = sumHead;
            } else {
                sumTail.next = new ListNode(partialSum);
                sumTail = sumTail.next;
            }
        }
        if (carry != 0) {
            sumTail.next = new ListNode(carry);
        }
        return sumHead;
    }

}
