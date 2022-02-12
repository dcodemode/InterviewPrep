package learn.ds.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
    127. Word Ladder

    A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

    Every adjacent pair of words differs by a single letter.
    Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
    sk == endWord
    Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

    Example 1:
    Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
    Output: 5
    Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
    
    Example 2:
    Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
    Output: 0
    Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
    
    Constraints:
    * 1 <= beginWord.length <= 10
    * endWord.length == beginWord.length
    * 1 <= wordList.length <= 5000
    * wordList[i].length == beginWord.length
    * beginWord, endWord, and wordList[i] consist of lowercase English letters.
    * beginWord != endWord
    * All the words in wordList are unique.
    
    https://leetcode.com/problems/word-ladder/

 */
public class WordLadder {
    
    /**
     * Breadth First Search
     * Time Complexity: O(V^2 E)
     * Space Complexuty: O(V E)
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        Set<String> word = new HashSet<>(wordList);
        word.remove(beginWord);
        q.offer(beginWord);
        
        int level = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size > 0){
                String currWord = q.poll();
                if(currWord.contains(endWord)){
                    return level + 1;
                }
                for(String nei : getNeighbors(currWord)){
                    if(word.contains(nei)){
                        word.remove(nei);
                        q.offer(nei);
                    }
                }
                size--;
            }
            level++;
        }
        return 0;
    }
    
    private List<String> getNeighbors(String word){
        char[] chars = word.toCharArray();
        List<String> result = new ArrayList<>();
        for(int i = 0 ; i < chars.length ; i++){
            char temp = chars[i];
            for(char c = 'a' ; c <= 'z' ; c++){
                chars[i] = c;
                String nei = new String(chars);
                result.add(nei);
            }
            chars[i] = temp;
        }
        return result;
    }
    
}
