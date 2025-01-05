package com.madimadica.leetcode;

/**
 * <a href="https://leetcode.com/problems/string-to-integer-atoi/">8. String to Integer (atoi)</a>
 * <p>
 *     Medium
 * </p>
 * <p>
 *    1 ms - Beats 100.00%
 * </p>
 */
public class Problem8_StringToInteger {

    public int myAtoi(String s) {
        int pos = 0;
        int len = s.length();
        while (pos < len && s.charAt(pos) == ' ') {
            pos++;
        }
        if (pos >= len) {
            return 0;
        }
        char next = s.charAt(pos);
        boolean negative;
        if (next == '+') {
            negative = false;
            pos++;
        } else if (next == '-') {
            negative = true;
            pos++;
        } else if (next < '0' || next > '9') {
            return 0;
        } else {
            negative = false;
        }
        int answer = 0;
        while (pos < len) {
            try {
                char ch = s.charAt(pos++);
                if (ch < '0' || ch > '9') {
                    break;
                }
                answer = Math.multiplyExact(answer, 10);
                answer = Math.addExact(answer, ch - 48);
            } catch (ArithmeticException e) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return negative ? -answer : answer;
    }

}
