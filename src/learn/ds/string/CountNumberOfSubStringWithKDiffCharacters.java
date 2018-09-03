package learn.ds.string;

import java.util.*;

/**
 * 9/2/18
 * @author Varma Penmetsa
 *
 * Given a string of lowercase alphabets, count all possible substrings (not necessarily distinct) that has exactly k distinct characters.
 *
 * Examples:
 *
 * Input: abc, k = 2
 * Output: 2
 * Possible substrings are {"ab", "bc"}
 *
 * Input: aba, k = 2
 * Output: 3
 * Possible substrings are {"ab", "ba", "aba"}
 *
 * Input: aa, k = 1
 * Output: 3
 * Possible substrings are {"a", "a", "aa"}
 *
 * https://www.geeksforgeeks.org/count-number-of-substrings-with-exactly-k-distinct-characters/
 */
public class CountNumberOfSubStringWithKDiffCharacters {

    //Print all substrings for given string
    public static List<String> printSubStrings(String str) {
        if (str == null) {
            return null;
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length() + 1; j++) {
                String s = str.substring(i, j);
                list.add(s);
            }
        }
        return list;
    }

    //Unique Character count
    public static int charCount(String str){
        Set<Character> charSet = new HashSet<>();
        for(int i=0; i< str.length();i++){
            charSet.add(str.charAt(i));
        }
        return charSet.size();
    }

    /**
     * Brute Force:
     * 1. Find all substrings
     * 2. In all substrings find substrings that contain k unique characters.
     *
     * Time Complexity: O(n^2)
     *
     */
    public static int distctSubString(String str, int k){
        List<String> subStr = printSubStrings(str);
        int count = 0;

        for(String s : subStr){
            if(charCount(s) == k){
                count++;
            }
        }
        return count;
    }

    /**
     * Using Sliding window approach (To-Do)
     *
     */


    public static void main(String[] args) {
        System.out.println(distctSubString("aba",2));
        //System.out.println(printSubStrings("abcd").toString());
    }
}
