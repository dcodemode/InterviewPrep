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
    public static boolean valid(String str) {

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
     * Greedy Approach
     *
     * Time Complexity   : O(n)
     * Space Complexity  : O(1)
     */

    public static boolean validate1(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            int j = n - 1 - i;
            if (s.charAt(i) != s.charAt(j)) {
                return (checkRange(s, i + 1, j) || checkRange(s, i, j - 1));
            }
        }
        return true;
    }

    public static boolean checkRange(String s, int i, int j) {
        for (int k = i; k <= i + (j - i) / 2; k++) {
            if (s.charAt(k) != s.charAt(j - k + i)){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        System.out.println(validate1("deeee"));
        System.out.println(validate1("abc"));
        System.out.println(validate1("aasasdasas"));

    }
}
