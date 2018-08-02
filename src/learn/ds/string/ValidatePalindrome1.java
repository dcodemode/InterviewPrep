package learn.ds.string;

/**
 * @author Varma Penmetsa
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * https://leetcode.com/problems/valid-palindrome/description/
 */
public class ValidatePalindrome1 {

    /**
     *
     * Time Complexity  : O(n)
     * Space Complexity : O(1)
     */
    public static boolean check(String str){
        if(str == null || str.length() == 0){
            return true;
        }
        str = str.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int n = str.length();

        for(int i=0; i < n/2 ; i++){
            if(str.charAt(i) != str.charAt(n-1-i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        System.out.println(check(str));
    }
}
