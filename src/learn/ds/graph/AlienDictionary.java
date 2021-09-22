package learn.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
There is a new alien language that uses the English alphabet. However, the order among the letters is unknown to you.

You are given a list of strings words from the alien language's dictionary, where the strings in words are sorted lexicographically by the rules of this new language.

Return a string of the unique letters in the new alien language sorted in lexicographically increasing order by the new language's rules. If there is no solution, return "". If there are multiple solutions, return any of them.

A string s is lexicographically smaller than a string t if at the first letter where they differ, the letter in s comes before the letter in t in the alien language. If the first min(s.length, t.length) letters are the same, then s is smaller if and only if s.length < t.length.

 

Example 1:

Input: words = ["wrt","wrf","er","ett","rftt"]
Output: "wertf"
Example 2:

Input: words = ["z","x"]
Output: "zx"
Example 3:

Input: words = ["z","x","z"]
Output: ""
Explanation: The order is invalid, so return "".

https://leetcode.com/problems/alien-dictionary/

*/

public class AlienDictionary {


    /**
     * A few things to keep in mind:
     * 
     * The letters within a word don't tell us anything about the relative order. For example, the presence of the word kitten in the list does not tell us that the letter k is before the letter i.
     * The input can contain words followed by their prefix, for example, abcd and then ab. These cases will never result in a valid alphabet (because in a valid alphabet, prefixes are always first). You'll need to make sure your solution detects these cases correctly.
     * There can be more than one valid alphabet ordering. It is fine for your algorithm to return any one of them.
     * Your output string must contain all unique letters that were within the input list, including those that could be in any position within the ordering. It should not contain any additional letters that were not in the input.
     * @param words
     * @return
     */
    public String alienOrder(String[] words) {

        // Step 0: Create data structures and find all unique letters.
        Map<Character, List<Character>> adjList = new  HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        
        for(String word : words ){
            for(char c : word.toCharArray()){
                adjList.put(c, new ArrayList<>());
                indegree.put(c, 0);
            }
        }
        
        // Step 1: Find all edges.
        for(int i = 0 ; i < words.length-1 ; i++){
            String word1 = words[i];
            String word2 = words[i+1];
            
            if(word1.length() > word2.length() && word1.startsWith(word2)){
                return "";
            }
            
            for(int j = 0 ; j < word1.length() ; j++){
                if(word1.charAt(j) != word2.charAt(j) ){
                    adjList.get(word1.charAt(j)).add(word2.charAt(j));
                    indegree.put(word2.charAt(j), indegree.get(word2.charAt(j)) + 1 );
                    break;
                }
            }
        }
        // Step 3: Kahn's Topological Sorting using BFS
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        
        for(Character c : indegree.keySet()){
            if(indegree.get(c) == 0){
                q.offer(c);
            }
        }
        
        while(!q.isEmpty()){
            Character c = q.poll();
            sb.append(c);
            
            for(char nei : adjList.get(c)){
                int charIndegree = indegree.get(nei) - 1;
                
                if(charIndegree == 0){
                    q.offer(nei);
                }
                
                indegree.put(nei, charIndegree);
            }
        }
        
        if(sb.length() < indegree.size()){
            return "";
        }
        return sb.toString();
    }
    
}
