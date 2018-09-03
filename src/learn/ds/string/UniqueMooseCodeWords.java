package learn.ds.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Varma Penmetsa
 *
 * nternational Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
 *
 * For convenience, the full table for the 26 letters of the English alphabet is given below:
 *
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, "cab" can be written as "-.-.-....-", (which is the concatenation "-.-." + "-..." + ".-"). We'll call such a concatenation, the transformation of a word.
 *
 * Return the number of different transformations among all words we have.
 *
 * https://leetcode.com/problems/unique-morse-code-words/description/
 */
public class UniqueMooseCodeWords {

    /**
     * Time Complexity  : O(n ^ 2)
     * Space Complexity : O(n)
     */

    public static int uniqueMooseRepresentation(String[] words){
        if(words.length == 0){
            return 0;
        }else if(words.length == 1){
            return 1;
        }

        String[] mooseCodes = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> uSet = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for(String word : words){
            sb.setLength(0);
            for(char c : word.toCharArray()){
                sb.append(mooseCodes[c - 97]);
            }
            uSet.add(sb.toString());
        }
        return uSet.size();
    }

    public static void main(String[] args) {
        String[] words = new String[]{"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMooseRepresentation(words));
    }
}
