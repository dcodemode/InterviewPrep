package learn.ds.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note
 *
 * Example 1:
 *
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 *
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 *
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 *
 *
 * Constraints:
 * You may assume that both strings contain only lowercase letters.
 *
 * https://leetcode.com/problems/ransom-note/
 *
 */
public class RansomNote {

    /**
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * https://www.youtube.com/watch?v=gWqbmAS3uxg
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for(Character c : magazine.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        for(Character c :ransomNote.toCharArray()){
            if(!map.containsKey(c) || map.get(c) <= 0){
                return false;
            }
            map.put(c, map.get(c)-1);
        }
        return true;
    }
}
