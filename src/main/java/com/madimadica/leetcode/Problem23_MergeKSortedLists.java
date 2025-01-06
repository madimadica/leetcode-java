package com.madimadica.leetcode;

import com.madimadica.leetcode.api.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Problem23_MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] listsArray) {
        List<ListNode> lists = new ArrayList<>(Arrays.asList(listsArray));
        lists.removeIf(Objects::isNull);
        if (lists.isEmpty()) {
            return null;
        }

        while (lists.size() > 1) {
            List<ListNode> merged = new ArrayList<>();
            for (int i = 0; i < lists.size(); i += 2) {
                if (i + 1 == lists.size()) {
                    merged.add(lists.get(i));
                } else {
                    merged.add(mergeTwoLists(lists.get(i), lists.get(i + 1)));
                }
            }
            lists = merged;
        }

        return lists.get(0);
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        if (list1 != null) {
            tail.next = list1;
        }
        if (list2 != null) {
            tail.next = list2;
        }
        return dummyHead.next;
    }
}
