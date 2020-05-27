package learn.ds.string;

/**
 *
 * Given an input string, reverse the string word by word
 *
 * Example 1:
 *
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 *
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 *
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 *
 * Note:
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 * https://leetcode.com/problems/reverse-words-in-a-string/
 */

public class ReverseWordInAString {

    /**
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public String reverseWords(String s) {
        //Remove spaces
        StringBuffer sb = cleanUp(s);

        //Reverse the entire string
        reverse(sb, 0, sb.length() - 1);

        //Reverse each words
        reverseWord(sb);
        return sb.toString();

    }

    public StringBuffer cleanUp(String s) {
        int left = 0, right = s.length() - 1;
        //Remove leading spaces
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        //Remove trailing spaces
        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }

        //Remove spaces in between words
        StringBuffer sb = new StringBuffer();
        while (left <= right) {
            char c = s.charAt(left);
            if (c != ' ') {
                sb.append(c);
            } else if (sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            left++;
        }
        return sb;
    }

    public void reverse(StringBuffer sb, int left, int right) {
        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, temp);
        }
    }

    public void reverseWord(StringBuffer sb) {
        int n = sb.length();
        int left = 0, right = 0;
        while (left < n) {
            while (right < n && sb.charAt(right) != ' ') {
                right++;
            }
            reverse(sb, left, right - 1);
            left = right + 1;
            right++;
        }
    }
}
