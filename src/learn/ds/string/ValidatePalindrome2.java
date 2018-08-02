package learn.ds.string;

/**
 * @author Varma Penmetsa
 *
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 *
 * https://leetcode.com/problems/valid-palindrome-ii/description/
 *
 * https://leetcode.com/articles/valid-palindrome-ii/
 */
public class ValidatePalindrome2 {


    /**
     * Brute Force Approach
     *
     * Time Complexity   : O(n ^ 2)
     * Space Complexity  : O(n)
     *
     */
    public static boolean validPalindrome1(String str) {

        if(str == null || str.length() == 0){
            return true;
        }

        StringBuilder sb = new StringBuilder(str);
        int n = sb.length();

        for(int i = 0 ; i < n ; i++ ){
            if(sb.charAt(i) != sb.charAt(n - 1 - i)){
                char c = sb.charAt(i);
                sb.deleteCharAt(i);

                // Check for palindrome again
                if (check(sb)){
                    return true;
                }
                sb.insert(i,c);
            }
        }
        return check(sb);
    }

    public static boolean check(StringBuilder str){
        if(str == null || str.length() == 0){
            return true;
        }
        int n = str.length();

        for(int i=0; i < n/2 ; i++){
            if(str.charAt(i) != str.charAt(n-1-i)){
                return false;
            }
        }
        return true;
    }


    /**
     * TO-DO Greedy Approach
     */

    public static void main(String[] args) {
        System.out.println(validPalindrome1("abc"));
    }
}
