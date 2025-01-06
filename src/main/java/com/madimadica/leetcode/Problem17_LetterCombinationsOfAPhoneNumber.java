package com.madimadica.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/">17. Letter Combinations of a Phone Number</a>
 * <p>
 *     Medium
 * </p>
 * <p>
 *    0 ms - Beats 100.00%
 * </p>
 */
public class Problem17_LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return List.of();
        }
        List<String> output = new ArrayList<>();
        addCombinations(digits, 0, new StringBuilder(), output);
        return output;
    }

    private void addCombinations(String digits, int pos, StringBuilder current, List<String> out) {
        if (pos >= digits.length()) {
            out.add(current.toString());
            return;
        }

        char ch = digits.charAt(pos);
        if ('2' <= ch && ch <= '9') {
            String options = switch (ch - 48) {
                case 2 -> "abc";
                case 3 -> "def";
                case 4 -> "ghi";
                case 5 -> "jkl";
                case 6 -> "mno";
                case 7 -> "pqrs";
                case 8 -> "tuv";
                case 9 -> "wxyz";
                default -> throw new IllegalStateException();
            };
            for (int i = 0; i < options.length(); ++i) {
                current.append(options.charAt(i));
                addCombinations(digits, pos + 1, current, out);
                current.deleteCharAt(current.length() - 1);
            }
        } else {
            addCombinations(digits, pos + 1, current, out);
        }
    }

}
