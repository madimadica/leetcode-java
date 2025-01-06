package com.madimadica.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/generate-parentheses/">22. Generate Parentheses</a>
 * <p>
 *     Medium
 * </p>
 * <p>
 *    0 ms - Beats 100.00%
 * </p>
 */
public class Problem22_GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> outputs = new ArrayList<>();
        generate(new StringBuilder(), n, 0, 0, outputs);
        return outputs;
    }

    private void generate(StringBuilder sb, int n, int openings, int closings, List<String> outputs) {
        if (openings + closings == n * 2) {
            outputs.add(sb.toString());
            return;
        }

        if (openings < n) {
            sb.append('(');
            generate(sb, n, openings + 1, closings, outputs);
            sb.deleteCharAt(openings + closings);
        }
        if (closings < n && openings > closings) {
            sb.append(')');
            generate(sb, n, openings, closings + 1, outputs);
            sb.deleteCharAt(openings + closings);
        }
    }

}
