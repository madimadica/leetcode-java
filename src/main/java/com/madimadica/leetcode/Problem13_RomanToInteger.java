package com.madimadica.leetcode;

/**
 * <a href="https://leetcode.com/problems/integer-to-roman/">13. Roman to Integer</a>
 * <p>
 *     Easy
 * </p>
 * <p>
 *    3 ms - Beats 86.58%
 * </p>
 */
public class Problem13_RomanToInteger {

    public int romanToInt(String s) {
        int value = 0;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            boolean hasNext = i + 1 < s.length();
            char next = hasNext ? s.charAt(i + 1) : ' ';
            value += switch (ch) {
                case 'I' -> (next == 'V' || next == 'X') ? -1 : 1;
                case 'V' -> 5;
                case 'X' -> (next == 'L' || next == 'C') ? -10 : 10;
                case 'L' -> 50;
                case 'C' -> (next == 'D' || next == 'M') ? -100 : 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> throw new IllegalArgumentException("Invalid Character '" + ch + "'");
            };
        }
        return value;
    }

}
