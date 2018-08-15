package learn.ds.string.easy;

/**
 * Detect Capital
 *
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 *
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *   1. All letters in this word are capitals, like "USA".
 *   2. All letters in this word are not capitals, like "leetcode".
 *   3. Only the first letter in this word is capital if it has more than one letter, like "Google".
 *
 * Otherwise, we define that this word doesn't use capitals in a right way.
 *
 * Example 1:
 *   Input: "USA"
 *   Output: True
 *
 * Example 2:
 *   Input: "FlaG"
 *   Output: False
 *
 * Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 *
 * https://leetcode.com/problems/detect-capital/description/
 */
public class DetectCapital {

    /**
     * Using Regex
     * it will take at least O(m) time, where m is the length of the string
     */
    public static boolean detectCapitalUse1(String word) {
        return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
    }

    //Using built in methods
    public static boolean detectCapitalUse2(String word) {
        if(word == null || word.length() == 0){
            return false;
        }

        //Check if all letters are CAP
        if(word.equals(word.toUpperCase())){
            return true;
        }

        //Check if all chars are lower
        if(word.equals(word.toLowerCase())){
            return true;
        }
        //Check for Camel case
        return word.length() > 1 && word.substring(0, 1).equals(word.substring(0, 1).toUpperCase())
                && word.substring(1).equals(word.substring(1).toLowerCase());

    }

    public static void main(String[] args) {
        System.out.println(detectCapitalUse2("Leetcode"));
    }

}
