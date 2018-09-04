package learn.ds.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 9/3/18
 * @author Varma Penmetsa
 *
 * Length of the longest substring without repeating characters
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example:
 *
 * Input  :  “ABDEFGABEF”
 * Output :“BDEFGA” and “DEFGAB” with length 6.
 *
 * Input: “BBBB”
 * Output: “B”, with length 1.
 *
 * https://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/solution/
 */
public class LongestSubstringWithOutRepeatingCharacters {

    /**
     * Sliding window approach
     *
     * Time Complexity  : O(2n)
     * Space Complexity : O(d) , d is number of dist characters
     */

    public static int getSubstringLen(String str){
        if(str == null){
            return 0;
        }

        int ans = 0, left =0 , right= 0, n = str.length();
        Set<Character> set = new HashSet<>();

        while(left < n && right < n){
            if(!set.contains(str.charAt(right))){
                set.add(str.charAt(right++));
                ans = Math.max(ans, right-left);
            }else{
                set.remove(str.charAt(left++));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(getSubstringLen("BBBB"));
    }
}
