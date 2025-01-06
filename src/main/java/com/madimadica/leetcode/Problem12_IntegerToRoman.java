package com.madimadica.leetcode;

/**
 * <a href="https://leetcode.com/problems/integer-to-roman/">12. Integer to Roman</a>
 * <p>
 *     Medium
 * </p>
 * <p>
 *    3 ms - Beats 98.57%
 * </p>
 */
public class Problem12_IntegerToRoman {

    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        int thousands = (num / 1000);
        roman.append("M".repeat(thousands));
        num %= 1000;

        updateRoman(roman, num / 100, 'C', 'D', 'M');
        num %= 100;

        updateRoman(roman, num / 10, 'X', 'L', 'C');
        num %= 10;

        updateRoman(roman, num, 'I', 'V', 'X');
        return roman.toString();
    }

    private void updateRoman(StringBuilder sb, int digit, char ones, char fives, char tens) {
        switch (digit) {
            case 1, 2, 3 -> {
                switch (digit) {
                    // fall through
                    case 3:
                        sb.append(ones);
                    case 2:
                        sb.append(ones);
                    case 1:
                        sb.append(ones);
                        break;
                }
            }
            case 4 -> sb.append(ones).append(fives);
            case 5 -> sb.append(fives);
            case 6, 7, 8 -> {
                sb.append(fives);
                switch (digit) {
                    // fall through
                    case 8:
                        sb.append(ones);
                    case 7:
                        sb.append(ones);
                    case 6:
                        sb.append(ones);
                        break;
                }
            }
            case 9 -> sb.append(ones).append(tens);
        }
    }

}
