package com.madimadica.leetcode;

/**
 * <a href="https://leetcode.com/problems/longest-palindromic-substring/">5. Longest Palindromic Substring</a>
 * <p>
 *     Medium
 * </p>
 * <p>
 *    13 ms - Beats 94.75%
 * </p>
 */
public class Problem5_LongestPalindromicSubstring {

    /**
     * Given a string s, return the longest palindromic substring in s.
     * @param s String
     * @return the longest palindromic substring in s.
     */
    public String longestPalindrome(String s) {
        final int len = s.length();

        int bestL = 0;
        int bestR = 0;

        for (int center = 0; center < (len - 1); ++center) {
            for (int centerWidth = 0; centerWidth < 2; ++centerWidth) {
                int currentL = center;
                int currentR = center + centerWidth;
                while (0 <= currentL && currentR < len && (s.charAt(currentL) == s.charAt(currentR))) {
                    currentL--;
                    currentR++;
                }
                // Bring it back in range
                currentL++;
                currentR--;
                if ((bestR - bestL) < (currentR - currentL)) {
                    bestL = currentL;
                    bestR = currentR;
                }
            }
        }
        return s.substring(bestL, bestR + 1);
    }

}
