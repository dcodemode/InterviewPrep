package learn.ds.stack;


import java.util.Stack;

/**
 * @author Varma Penmetsa
 *
 * https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
 */
public class BalanceParentheses {

    public static boolean checkBalance(String s) {
        if (s.length() == 0 || s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        char[] c = s.toCharArray();

        if (c[0] == ']' || c[0] == '}' || c[0] == ')') {
            return false;
        }

        for (int i = 0; i < c.length; i++) {
            if (c[i] == '{') {
                stack.push('}');
            } else if (c[i] == '(') {
                stack.push(')');
            } else if (c[i] == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || c[i] != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        System.out.println(checkBalance("[()]"));

    }
}
