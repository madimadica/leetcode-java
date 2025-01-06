package com.madimadica.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/3sum-closest/">16. 3Sum Closest</a>
 * <p>
 *     Medium
 * </p>
 * <p>
 *    12 ms - Beats 97.98%
 * </p>
 */
public class Problem16_3SumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int smallestDiff = Integer.MAX_VALUE;
        int closestSum = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; ++i) {
            int x = nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = x + nums[l] + nums[r];
                int diff = Math.abs(target - sum);
                if (diff < smallestDiff) {
                    smallestDiff = diff;
                    closestSum = sum;
                }
                if (sum > target) {
                    r--;
                } else if (sum < target) {
                    l++;
                } else {
                    return target;
                }
            }
        }
        return closestSum;
    }

}
