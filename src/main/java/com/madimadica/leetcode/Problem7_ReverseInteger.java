package com.madimadica.leetcode;

/**
 * <a href="https://leetcode.com/problems/reverse-integer/description/">7. Reverse Integer</a>
 * <p>
 *     Medium
 * </p>
 * <p>
 *    1 ms - Beats 85.04%
 * </p>
 */
public class Problem7_ReverseInteger {

    /**
     * <strong>Assume the environment does not allow you to store 64-bit integers (signed or unsigned).</strong>
     * @param x number to reverse
     * @return revered number
     */
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        boolean isNegative = x < 0;
        if (isNegative) {
            x = -x;
        }

        int answer = 0;
        int val = 1;
        try {
            while (val <= x) {
                int digit = (x / val) % 10;
                answer = Math.multiplyExact(answer, 10);
                answer = Math.addExact(answer, digit);
                if (val == 1_000_000_000) {
                    break;
                }
                val *= 10;
            }
            if (isNegative) {
                answer = Math.negateExact(answer);
            }
            return answer;
        } catch (ArithmeticException e) {
            return 0;
        }
    }
}
