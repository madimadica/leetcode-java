package com.madimadica.leetcode;

import com.madimadica.leetcode.api.ListNode;

/**
 * <a href="https://leetcode.com/problems/merge-two-sorted-lists/">21. Merge Two Sorted Lists</a>
 * <p>
 *     Easy
 * </p>
 * <p>
 *    0 ms - Beats 100.00%
 * </p>
 */
public class Problem21_MergeTwoSortedLists {

    /**
     * Merge two sorted lists into a single sorted output list.
     * Destructive to the input arguments (mutates)
     * @param list1 first sorted list
     * @param list2 second sorted list
     * @return a sorted list will all the elements from list1 and list2
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode currentAnswer = dummyHead;

        ListNode current1 = list1;
        ListNode current2 = list2;

        while (current1 != null && current2 != null) {
            ListNode node;
            if (current1.val < current2.val) {
                node = current1;
                current1 = current1.next;
            } else {
                node = current2;
                current2 = current2.next;
            }
            currentAnswer.next = node;
            currentAnswer = currentAnswer.next;
        }
        if (current1 != null) {
            currentAnswer.next = current1;
        }
        if (current2 != null) {
            currentAnswer.next = current2;
        }
        return dummyHead.next;
    }
}
