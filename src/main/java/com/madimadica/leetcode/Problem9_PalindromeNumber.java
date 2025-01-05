package com.madimadica.leetcode;

/**
 * <a href="https://leetcode.com/problems/palindrome-number/">9. Palindrome Number</a>
 * <p>
 *     Easy
 * </p>
 * <p>
 *    5 ms - Beats 71.62%
 * </p>
 */
public class Problem9_PalindromeNumber {

    public boolean isPalindrome(int x) {
        int reversed = 0;
        int num = x;
        while (num > 0) {
            reversed *= 10;
            reversed += num % 10;
            num /= 10;
        }
        return x == reversed;
    }
}
