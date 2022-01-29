package crackingcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
    Given a string, return the character that appears the maximum number of times in the string. The string will contain only
    ASCII characters, from the ranges ('a'-'z', 'A'-'Z', 0-9'), and case matters. If there is a tie in the maximum number of times a
    character appears in the string, return the character that appears first in the string.

    Example
    text = abbbaacc

    Both 'a'and 'b'occur 3 times in text. Since 'a' occurs earlier, a is the answer.
    
    Returns
    char: The most occurring character that appears first in the string.
    
    Constraints
    10 ≤ | text| ≤ 104
    All characters are alphanumeric, in the ranges ('a'-'z','A'-'Z','O'-'9')
 */

public class MaxCharCount {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param text
     * @return
     */
    public static Character getMaxChar(String text){
        if(text == null || text.length() == 0){
            return null;
        }
    
        Map<Character, List<Integer>> map = new HashMap<>();
        int maxChar = 0;

        for(int i = 0 ; i < text.length() ; i++){
            char ch = text.charAt(i);
            if(map.containsKey(ch)){
                map.get(ch).add(i);
            }else{
                map.put(ch, new ArrayList<>(Arrays.asList(i)));
            }
            maxChar = Math.max(maxChar, map.get(ch).size());
        }

        char ans  = '&';
        for(Entry<Character, List<Integer>> entry : map.entrySet()){
            char key = entry.getKey();
            List<Integer> indicesList = entry.getValue();

            if(indicesList.size() ==  maxChar && ans == '&'){
                ans = key;
            }else if(indicesList.size() ==  maxChar && ans != '&'){
                int x = map.get(ans).get(0);
                int y = indicesList.get(0);
                if(x > y){
                    ans = key;
                }
            }
        }

        return ans == '&' ? null : ans;
    }

    public static void main(String[] args) {
        String[] texts = {"helloworld", "abaa", "bbbaaacc" };
        
        for (String text : texts){
            System.out.println(getMaxChar(text));
        }
    }
    
}
