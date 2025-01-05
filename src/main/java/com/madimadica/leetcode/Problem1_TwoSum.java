package com.madimadica.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/two-sum/description/">1. Two Sum</a>
 * <p>
 *     2 ms - Beats 98.94%
 * </p>
 */
public class Problem1_TwoSum {
    /**
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     * @param nums array of integers
     * @param target expected sum
     * @return indices of the two numbers adding up to the target
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numberIndices = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int current = nums[i];
            int missingValue = target - current;
            Integer index = numberIndices.get(missingValue);
            if (index != null) {
                return new int[] {i, index};
            }
            numberIndices.put(current, i);
        }
        throw new RuntimeException("No solution");
    }
}
