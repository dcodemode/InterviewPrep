package learn.ds.string;

/**
 * 3/8/18
 * @author Varma Penmetsa
 *
 * Given a string, find the longest substring which is palindrome.
 *
 * Example,
 *  Input  : forgeeksskeegfor
 *  Output : geeksskeeg
 *
 * https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
 * https://leetcode.com/problems/longest-palindromic-substring/solution/
 * https://www.youtube.com/watch?v=Fi5INvcmDos&t=414s&frags=pl%2Cwn
 */
public class FindLongestPalindromeSubstring {

    /**
     * DP solution
     * Time Complexity  : O(n^2)
     * Space Complexity : O(n^2)
     */
    public static String longestPalidrome(String str){

        int n = str.length();

        //Creating matrix of size str * str
        boolean[][] table = new boolean[n][n];

        // All substrings of length 1 are palindromes
        int maxLength = 1;
        for (int i = 0; i < n; i++) {
            table[i][i] = true;
        }

        //Check for sub-string of length 2.
        int start = 0;
        for(int i =0 ; i < n -1 ; i++){
            if(str.charAt(i) == str.charAt(i+1)){
                table[i][i+1] = true;
                start = i;
                maxLength = 2;
            }
        }

        //Check for length greater that 2.
        for (int k = 3; k < n; k++) {
            for (int i = 0; i < n - k + 1; i++) {
                int j = i + k - 1;
                if (table[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
                    table[i][j] = true;
                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }

        return str.substring(start, start + maxLength);
    }


    public static void main(String[] args) {
        System.out.println(longestPalidrome("geeksskeeg"));
    }
}
