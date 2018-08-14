package learn.ds.string.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Varma Penmetsa
 *
 * Given a string, you need to reverse the order of characters in each word within a sentence while
 * still preserving whitespace and initial word order.
 *
 * Example 1:
 *   Input: "Let's take LeetCode contest"
 *   Output: "s'teL ekat edoCteeL tsetnoc"
 *
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 *
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
 */
public class ReverseWordInString2 {

    /**
     * Brute Force
     * Time Complexity  : O(n)
     * Space Complexity : O(n)
     */
    public static String reverseWords(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        String[] words = strSplit(s);
        for(String word : words){
            sb.append(reverse(word) + " ");
        }
        return sb.toString().trim();
    }

    /**
     * Split String
     */
    public static String[] strSplit(String line){
        if(line == null ||  line.length() == 0){
            return null;
        }
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(char c : line.toCharArray()){
            if(c == ' '){
                list.add(sb.toString());
                sb = new StringBuilder();
            }else{
                sb.append(c);
            }
        }
        list.add(sb.toString());
        return list.toArray(new String[list.size()]);
    }

    /**
     * Reverse a string
     */
    public static String reverse(String str){
        if(str == null || str.length() == 0){
            return str;
        }
        char[] c = str.toCharArray();
        int n = str.length() -1;

        for(int i=0 ; i <= n/2 ; i++){
            char temp = c[i];
            c[i] = c[n - i];
            c[n - i] = temp;
        }
        return String.valueOf(c);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's Take LeetCode Contest"));
    }

}
