package learn.ds.string;

/**
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 *
 * Example 1:
 *
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * Example 2:
 *
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * Example 3:
 *
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * Example 4:
 *
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 * Note:
 *
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 *
 * Follow up: Can you solve it in O(N) time and O(1) space?
 *
 *
 */
public class BackSpaceStringCompare {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1) since we are only dealing with characters
     */
    public static String uniqStr(String str){
        if(str==null || str.length() == 0){
            return str;
        }
        char[] chars = str.toCharArray();
        int n = chars.length -1;
        int backSpace = 0;
        StringBuilder ret = new StringBuilder();
        while(n >= 0){
            if(chars[n] == '#'){
                backSpace = backSpace + 1;
                n--;
            }else if(backSpace != 0){
                backSpace = backSpace - 1;
                n--;
            }else{
                ret.append(chars[n--]);
            }
        }
        return ret.toString();
    }

    public static boolean backspaceCompare(String S, String T) {
        return uniqStr(S).equals(uniqStr(T));
    }
}
