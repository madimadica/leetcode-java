package com.madimadica.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/valid-parentheses/">20. Valid Parentheses</a>
 * <p>
 *     Easy
 * </p>
 * <p>
 *    2 ms - Beats 97.60%
 * </p>
 */
public class Problem20_ValidParentheses {

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            boolean opening = ch == '(' || ch == '{' || ch == '[';
            if (opening) {
                stack.addLast(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char expectedClosing = switch (stack.removeLast()) {
                    case '(' -> ')';
                    case '[' -> ']';
                    case '{' -> '}';
                    default -> '#';
                };
                if (ch != expectedClosing) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
