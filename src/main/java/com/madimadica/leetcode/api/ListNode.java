package com.madimadica.leetcode.api;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

// Definition for singly-linked list.
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode of(Integer... values) {
        return ListNode.of(List.of(values));
    }

    public static ListNode of(List<Integer> values) {
        if (values.isEmpty()) {
            return null;
        }
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        for (int val : values) {
            tail.next = new ListNode(val);
            tail = tail.next;
        }
        return dummy.next;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(" -> ");

        ListNode current = this;
        List<ListNode> seen = new ArrayList<>();
        boolean cycle = false;
        while (current != null) {
            if (seen.contains(current)) {
                cycle = true;
                break;
            }
            seen.add(current);
            sj.add(String.valueOf(current.val));
            current = current.next;
        }

        if (cycle) {
            sj.add("[CYCLE [%d]]".formatted(current.val));
        }
        return sj.toString();
    }
}
