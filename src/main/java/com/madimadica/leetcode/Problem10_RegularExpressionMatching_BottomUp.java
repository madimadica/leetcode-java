package com.madimadica.leetcode;

/**
 * <a href="https://leetcode.com/problems/regular-expression-matching/">10. Regular Expression Matching</a>
 * <p>
 *     Hard
 * </p>
 * <p>
 *    2 ms - Beats 64.85%
 * </p>
 */
public class Problem10_RegularExpressionMatching_BottomUp {

    public boolean isMatch(String s, String p) {
        boolean[][] T = new boolean[s.length() + 1][p.length() + 1];
        T[0][0] = true; // Empty text, empty pattern

        // Update top row (Empty text, different patterns)
        for (int i = 2; i < T[0].length; ++i) {
            if (p.charAt(i - 1) == '*') {
                T[0][i] = T[0][i - 2];
            }
        }

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; ++j) {
                char textChar = s.charAt(i - 1);
                char patternChar = p.charAt(j - 1);
                if (patternChar == '.' || textChar == patternChar) {
                    T[i][j] = T[i - 1][j - 1];
                } else if (patternChar == '*') {
                    T[i][j] = T[i][j - 2];
                    char beforeWildcard = p.charAt(j - 2);
                    if (beforeWildcard == '.' || beforeWildcard == textChar) {
                        T[i][j] |= T[i - 1][j];
                    }
                } else {
                    T[i][j] = false;
                }
            }
        }
        return T[s.length()][p.length()];
    }
}
