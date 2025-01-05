package com.madimadica.leetcode;

/**
 * <a href="https://leetcode.com/problems/regular-expression-matching/">10. Regular Expression Matching</a>
 * <p>
 *     Hard
 * </p>
 * <p>
 *    1 ms - Beats 100.00%
 * </p>
 */
public class Problem10_RegularExpressionMatching {

    private final Boolean[][] MEMO = new Boolean[21][21];
    private String str;
    private String pattern;

    public boolean isMatch(String s, String p) {
        this.str = s;
        this.pattern = p;
        return isMatch(0, 0);
    }

    private boolean isMatch(int strStart, int patternStart) {
        Boolean memoizedValue = MEMO[strStart][patternStart];
        if (memoizedValue != null) {
            return memoizedValue;
        }
        boolean answer;
        if (patternStart == pattern.length()) {
            answer = strStart == str.length();
        } else {
            char pChar = pattern.charAt(patternStart);
            boolean matchesFirst = strStart < str.length()
                    && (pChar == '.' || pChar == str.charAt(strStart));
            if (patternStart + 1 < pattern.length() && pattern.charAt(patternStart + 1) == '*') {
                // Short Circuit with either consuming none, or consuming 1 greedily
                answer = isMatch(strStart, patternStart + 2)
                        || (matchesFirst && isMatch(strStart + 1, patternStart));
            } else {
                answer = matchesFirst && isMatch(strStart + 1, patternStart + 1);
            }
        }
        MEMO[strStart][patternStart] = answer;
        return answer;
    }
}
