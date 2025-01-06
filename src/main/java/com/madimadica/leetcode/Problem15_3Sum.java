package com.madimadica.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.com/problems/3sum/">15. 3Sum</a>
 * <p>
 *     Medium
 * </p>
 * <p>
 *    29 ms - Beats 71.94%
 * </p>
 */
public class Problem15_3Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        nums = IntStream.of(nums).sorted().toArray();
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            int x = nums[i];
            if (i > 0 && nums[i - 1] == x) {
                continue; // Skip duplicates
            }

            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                int sum = x + nums[l] + nums[r];
                if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    // New solution
                    output.add(List.of(x, nums[l], nums[r]));
                    l++;
                    while (nums[l] == nums[l - 1] && l < r) {
                        l++; // Duplicate 2nd entry, which cascades to 3rd
                    }
                }
            }
        }
        return output;
    }

}
