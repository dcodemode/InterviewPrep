package learn.ds.string;

import java.util.Stack;

/**
 * Leetcode 678. Valid Parenthesis String
 *
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:
 *
 * 1. Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * 2. Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * 3. Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * 4. '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * 5. An empty string is also valid.
 *
 * Example 1:
 *      Input: "()"
 *      Output: True
 * Example 2:
 *      Input: "(*)"
 *      Output: True
 * Example 3:
 *      Input: "(*))"
 *      Output: True
 * Note: The string size will be in the range [1, 100].
 *
 * https://leetcode.com/problems/valid-parenthesis-string/
 * https://www.youtube.com/watch?v=KuE_Cn3xhxI
 */

public class ValidateParenthesisString {

    Stack<Integer> open = new Stack<Integer>();
    Stack<Integer> star = new Stack<Integer>();

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public boolean checkValidString(String s) {
        if (s == null) {
            return true;
        }
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(') {
                open.push(i);
            } else if (c[i] == '*') {
                star.push(i);
            } else {
                if (!open.isEmpty()) {
                    open.pop();
                } else {
                    if (!star.isEmpty()) {
                        star.pop();
                    } else {
                        return false;
                    }
                }
            }
        }

        while (!open.isEmpty()) {
            if (!star.isEmpty() && open.peek() < star.peek()) {
                star.pop();
                open.pop();
            } else {
                return false;
            }
        }
        return true;
    }

}
