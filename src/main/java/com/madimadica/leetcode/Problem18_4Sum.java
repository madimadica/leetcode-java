package com.madimadica.leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/4sum/">18. 4Sum</a>
 * <p>
 *     Medium
 * </p>
 * <p>
 *    14 ms - Beats 90.42%
 * </p>
 */
public class Problem18_4Sum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> answers = new ArrayList<>();

        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            int a = nums[i];
            if (i > 0 && nums[i - 1] == a) {
                continue;
            }

            for (int j = i + 1; j < len; ++j) {
                int b = nums[j];
                if (j > i + 1 && nums[j - 1] == b) {
                    continue;
                }

                int l = j + 1;
                int r = len - 1;
                while (l < r) {
                    int c = nums[l];
                    int d = nums[r];
                    long sum = (long) a + b + c + d;
                    if (sum > target) {
                        r--;
                    } else if (sum < target) {
                        l++;
                    } else {
                        answers.add(List.of(a, b, c, d));
                        do {
                            l++;
                        } while (nums[l] == nums[l - 1] && l < r);
                    }
                }
            }
        }
        return answers;
    }
}
