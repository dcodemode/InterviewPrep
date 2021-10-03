package learn.ds.string;

/*
Implement strStr().
Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:
What should we return when needle is an empty string? This is a great question to ask during an interview.
For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Example 3:

Input: haystack = "", needle = ""
Output: 0
 

Constraints:

0 <= haystack.length, needle.length <= 5 * 104
haystack and needle consist of only lower-case English characters.

https://leetcode.com/problems/implement-strstr/
*/
public class ImplementstrStr {

    /**
     * KMP Algo to match strings
     * 
     * Time Complexity: O(m + n)
     * Space Complexity: O(m)
     * 
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null || needle.length() > haystack.length()){
            return -1;
        }
        // Build KMP Table for pattern
        int i = 0;
        int j = 0;
        int[] kmp = generateKMPTable(needle.toCharArray());

        while(i < haystack.length() && j < needle.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++; j++;
            }else if(j > 0){
                j = kmp[j-1];
            }else{
                i++;
            }
        }
        return -1;
    }

    public int[] generateKMPTable(char[] pattern){
        int i = 0, j = 1, n = pattern.length;

        int[] table = new int[n];

        while(j < n){
            if(pattern[i] == pattern[j]){
                table[j] = i + 1;
                i++;
                j++;
            }else{
                if(i != 0){
                    i = table[i-1];
                }else{
                    j++;
                }
            }
        }
        return table;
    }

    
}
