package com.madimadica.leetcode;

/**
 * <a href="https://leetcode.com/problems/zigzag-conversion/">6. Zigzag Conversion</a>
 * <p>
 *     Medium
 * </p>
 * <p>
 *    5 ms - Beats 66.69%
 * </p>
 */
public class Problem6_ZigzagConversion {
    
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] rowBuilders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; ++i) {
            rowBuilders[i] = new StringBuilder();
        }
        int direction = 1;
        int row = 0;
        for (int i = 0; i < s.length(); ++i) {
            rowBuilders[row].append(s.charAt(i));
            row += direction;
            if (row == numRows) {
                row = numRows - 2;
                direction = -1;
            } else if (row == -1) {
                row = 1;
                direction = 1;
            }
        }
        StringBuilder answer = new StringBuilder(s.length());
        for (var rowBuilder : rowBuilders) {
            answer.append(rowBuilder.toString());
        }
        return answer.toString();
    }

}
