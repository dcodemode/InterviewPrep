package crackingcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 *  1. 4 Strings & Arrays
 *
 * Given a string, write a function to check if it is a permutation of a palindrome.
 *
 * A palindrome is a word or phrase that is the same forwards and backwards. A permutation is a rearrangement of letters.
 *
 * The palindrome does not need to be limited to just dictionary words. You can ignore casing and non-letter characters.
 *
 * EXAMPLE
 * Input: Tact Coa
 * Output: True (permutations: “taco cat”. “atco cta”. etc.)
 *
 */
public class PalindromePermutations {
    /**
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     */
    public static boolean check(String text){
        if(text==null){
            return false;
        }

        int[] table = new int[26];

        for(char letter : text.toCharArray()){
            if(Character.isLetter(letter)){
                char c = Character.toLowerCase(letter);
                table[c  - 'a']++;

            }
        }

        int single_char = 0;
        for(int val : table){
            if(val % 2 != 0){
                single_char++;
            }
        }

        return single_char <= 1;
    }

    public static void main(String[] args) {
        System.out.println(check("tactcoapapa"));
    }

}
