package com.madimadica.leetcode;

/**
 * <a href="https://leetcode.com/problems/longest-common-prefix/">14. Longest Common Prefix</a>
 * <p>
 *     Easy
 * </p>
 * <p>
 *    1 ms - Beats 63.55%
 * </p>
 */
public class Problem14_LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        int prefixLength = 0;
        String first = strs[0];
        OUTER:
        while (prefixLength < first.length()) {
            char target = first.charAt(prefixLength);
            for (int i = 1; i < n; ++i) {
                String other = strs[i];
                if (other.length() <= prefixLength || other.charAt(prefixLength) != target) {
                    break OUTER;
                }
            }
            prefixLength++;
        }
        return strs[0].substring(0, prefixLength);
    }
}
