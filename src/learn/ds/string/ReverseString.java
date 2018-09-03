package learn.ds.string;

/**
 * @author Varma Penmetsa
 *
 * Write a function that takes a string as input and returns the string reversed.
 *
 * Example 1:
 *    Input: "hello"
 *    Output: "olleh"
 *
 *Example 2:
 *    Input: "A man, a plan, a canal: Panama"
 *    Output: "amanaP :lanac a ,nalp a ,nam A"
 *
 * https://leetcode.com/problems/reverse-string/description/
 */
public class ReverseString {

    /**
     * Time Complexity  : O(n)
     * Space Complexity : O(1)
     */

    public static String reverseString(String s) {
        if(s == "" || s.length() == 0 || s.length() == 1){
            return s;
        }

        char[] c = s.toCharArray();
        int n = c.length-1;
        System.out.println(n/2);

        for (int i=0; i <= n/2 ; i++){
            char temp = c[i];
            c[i]=c[n-i];
            c[n-i]=temp;
        }
        return new String(c);
    }

    public static void main(String[] args) {
        System.out.println(reverseString("A mana"));
    }// anma A
}
