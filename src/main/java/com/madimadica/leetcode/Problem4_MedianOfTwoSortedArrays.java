package com.madimadica.leetcode;

/**
 * <a href="https://leetcode.com/problems/median-of-two-sorted-arrays/description/">4. Median of Two Sorted Arrays</a>
 * <p>
 *     Hard
 * </p>
 * <p>
 *     2 ms - Beats 59.03%
 * </p>
 */
public class Problem4_MedianOfTwoSortedArrays {

    /**
     * Given two sorted arrays nums1 and nums2 of size m and n respectively,
     * return the median of the two sorted arrays.
     *
     * @param nums1 sorted array of numbers
     * @param nums2 sorted array of numbers
     * @return The median of nums1 and nums2
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int totalLength = nums1.length + nums2.length;
        final int half = totalLength / 2;
        final boolean isEven = (totalLength & 1) == 0;

        // Force nums1 to be the smaller array
        int[] a = nums1;
        int[] b = nums2;
        if (nums2.length < nums1.length) {
            a = nums2;
            b = nums1;
        }

        // Binary search on A
        int left = 0;
        int right = a.length - 1;
        while (true) {
            int aMid = Math.floorDiv(left + right, 2);
            int bMid = half - aMid - 2;

            int aMidVal = getOrElse(a, aMid, Integer.MIN_VALUE);
            int aNextVal = getOrElse(a, aMid + 1, Integer.MAX_VALUE);
            int bMidVal = getOrElse(b, bMid, Integer.MIN_VALUE);
            int bNextVal = getOrElse(b, bMid + 1, Integer.MAX_VALUE);

            if (aMidVal <= bNextVal && bMidVal <= aNextVal) {
                if (isEven) {
                    return (Math.max(aMidVal, bMidVal) + Math.min(aNextVal, bNextVal)) / 2.0;
                } else {
                    return Math.min(aNextVal, bNextVal);
                }
            } else if (aMidVal > bNextVal) {
                right = aMid - 1;
            } else {
                left = aMid + 1;
            }
        }
    }

    private static int getOrElse(int[] array, int index, int defaultValue) {
        if (0 <= index && index < array.length) {
            return array[index];
        } else {
            return defaultValue;
        }
    }
}
