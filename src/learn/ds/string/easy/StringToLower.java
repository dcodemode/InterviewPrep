package learn.ds.string.easy;

/**
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 *
 * ASCII Table : https://www.cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html
 *
 * https://leetcode.com/problems/to-lower-case
 */
public class StringToLower {

    public static String toLower(String str) {
        if (str == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            sb.append((c >= 65 && c <= 90) ? (char) (c + 32) : c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(toLower("Test tesT tESt"));
    }
}
