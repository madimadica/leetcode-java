package com.madimadica.leetcode;

import java.util.BitSet;

/**
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/description/">3. Longest Substring Without Repeating Characters</a>
 * <p>
 *     Medium
 * </p>
 * <p>
 *     3 ms - Beats 90.07%
 * </p>
 * <p>
 *     This solution uses a bitmask of codepoints to represent the seen characters within a sliding window.
 * </p>
 */
public class Problem3_LongestSubstringWithoutRepeatingCharacters {

    /**
     * Given a string s, find the length of the longest
     * substring without repeating characters.
     * <br>
     * <p>
     *     Constraints: Consists of english letters, digits, symbols, and spaces
     * </p>
     * @param s String to search
     * @return length of the longest unique substring
     */
    public int lengthOfLongestSubstring(String s) {
        final int len = s.length();


        int bestWindow = 0;
        int windowStart = 0;
        BitSet windowCodepoints = new BitSet();

        // Sliding window from windowStart to i;
        for (int i = 0; i < len; ++i) {
            int currentCodepoint = s.codePointAt(i);
            boolean seen = windowCodepoints.get(currentCodepoint);
            if (seen) {
                bestWindow = Math.max(bestWindow, i - windowStart);
                // Move the start of the sliding window forward until the duplicate
                for (int j = windowStart; j < i; ++j) {
                    int headCodepoint = s.codePointAt(j);
                    if (headCodepoint == currentCodepoint) {
                        windowStart = j + 1;
                        break;
                    }
                    // Un-see the others
                    windowCodepoints.set(headCodepoint, false);
                }
            } else {
                windowCodepoints.set(currentCodepoint, true);
            }
        }
        // Goalpost problem:
        bestWindow = Math.max(bestWindow, len - windowStart);
        return bestWindow;
    }
}
