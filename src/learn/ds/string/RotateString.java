package learn.ds.string;

import java.util.Stack;

/**
 * @author Varma Penmetsa
 */
public class RotateString {


    /**
     * Using StringBuilder reverse function
     * <p>
     * Time Complexity  : O(n)
     * Space Complexity : O(n)
     */
    public static void reverse1(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder(str);
        System.out.println(sb.reverse());
    }

    /**
     * Using stack
     *
     * Time Complexity  : O(n)
     * Space Complexity : O(n)
     */
    public static void reverse2(String str) {
        if (str == null || str.length() == 0) {
            return;
        }

        char[] charArray = str.toCharArray();
        Stack<Character> st = new Stack<Character>();

        for (int i = 0; i < charArray.length; i++) {
            st.push(charArray[i]);
        }

        while (!st.isEmpty()) {
            System.out.print(st.pop());
        }
        System.out.println();
    }

    /**
     * Time Complexity  : O(n)
     * Space Complexity : O(1)
     */
    public static void reverse3(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        char[] charArray = str.toCharArray();
        int n = charArray.length;

        for (int i = 0; i < n / 2; i++) {
            char temp = charArray[i];
            charArray[i] = charArray[n - 1 - i];
            charArray[n - 1 - i] = temp;
        }

        System.out.println(charArray);
    }

    /**
     * Using recursion
     *
     * Time Complexity  : O(n)
     * Space Complexity : O(n)
     */
    public static void reverse4(String str, int n){
        if(str == null || str.length() == 0 || n < 0){
            return;
        }
        System.out.print(str.charAt(n));
        reverse4(str, n-1);
    }

    public static void main(String[] args) {
        reverse4("Test", 3);
    }
}
