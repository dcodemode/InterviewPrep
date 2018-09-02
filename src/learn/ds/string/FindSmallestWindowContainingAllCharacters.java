package learn.ds.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 9/2/18
 * @author Varma Penmetsa
 *
 * Find the smallest window in a string containing all characters of another string
 *
 * Given two strings string1 and string2, find the smallest substring in string1 containing all characters of string2 efficiently.
 * For Example:
 *
 * Input :  string = "this is a test string"
 *          pattern = "tist"
 * Output :  Minimum window is "t stri"
 * Explanation: "t stri" contains all the characters of pattern.
 *
 * Input :  string = "geeksforgeeks"
 *          pattern = "ork"
 * Output :  Minimum window is "ksfor"
 *
 * https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
 * https://leetcode.com/problems/minimum-window-substring/solution/
 */
public class FindSmallestWindowContainingAllCharacters {


    /**
     *Algorithm
     * 1. We start with two pointers, left and right initially pointing to the first element of the string S.
     * 2. We use the right pointer to expand the window until we get a desirable window i.e. a window that contains all of the characters of T.
     * 3. Once we have a window with all the characters, we can move the left pointer ahead one by one. If the window is still a desirable one we keep on updating the minimum window size.
     * 4. If the window is not desirable any more, we repeat step2 onwards.
     *
     * Time Complexity  : O(S + T) where S, T represent the lengths of strings S & T
     * Space Complexity : O(S + T)
     */
    public static String getMin(String str, String pattern){

        if(str.length() == 0 || pattern.length() == 0){
            return "";
        }

        //Count all unique characters in pattern
        Map<Character,Integer> patternDict = new HashMap<>();
        for(int i =0 ; i < pattern.length(); i++){
            int count = patternDict.getOrDefault(pattern.charAt(i),0);
            patternDict.put(pattern.charAt(i),count+1);
        }

        //Number of unique characters that need to present in the desired window.
        int required = patternDict.size();

        //Left and Right pointer
        int left =0, right = 0;

        //Keeps track of how many unique characters in pattern are present in the current window.
        int formed = 0;

        //Map that keeps count of all unique characters in current window.
        Map<Character, Integer> windowCounts = new HashMap<>();

        //ans list of form (window length, left, right)
        int[] ans = {-1, 0, 0};

        while(right < str.length()){
            //Add one by one characters from right to window
            char c = str.charAt(right);
            int count = windowCounts.getOrDefault(c,0);
            windowCounts.put(c,count+1);

            if(patternDict.containsKey(c) && windowCounts.get(c).intValue() == patternDict.get(c).intValue()){
                formed++;
            }

            //Try to contact the window till the point where it is desirable
            while(left <=right && formed == required){
                c = str.charAt(left);
               //Save the smallest window until now.
                if(ans[0] == -1 || right - left + 1 < ans[0]){
                    ans[0] = right-left+1;
                    ans[1] = left;
                    ans[2] = right;
                }

                windowCounts.put(c,windowCounts.get(c)-1);
                if (patternDict.containsKey(c) && windowCounts.get(c).intValue() < patternDict.get(c).intValue()) {
                    formed--;
                }
                left++;

            }
            right++;
        }
        return ans[0] == -1 ? "" : str.substring(ans[1], ans[2]+1);

    }

    public static void main(String[] args) {
        System.out.println(getMin("this is a test string","tist"));
        System.out.println(getMin("geeksforgeeks","ork"));
    }

}
