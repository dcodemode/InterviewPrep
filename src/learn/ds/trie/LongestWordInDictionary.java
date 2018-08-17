package learn.ds.trie;

import java.util.Stack;

/**
 * @author Varma Penmetsa
 *
 * Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character
 * at a time by other words in words. If there is more than one possible answer, return the longest word with the smallest
 * lexicographical order.
 *
 * If there is no answer, return the empty string.
 *
 * Example 1:
 * Input:
 * words = ["w","wo","wor","worl", "world"]
 * Output: "world"
 * Explanation:
 * The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
 *
 * Example 2:
 * Input:
 * words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * Output: "apple"
 * Explanation:
 * Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
 * 
 * Note:
 * 
 * All the strings in the input will only contain lowercase letters.
 * The length of words will be in the range [1, 1000].
 * The length of words[i] will be in the range [1, 30].
 * 
 * https://leetcode.com/problems/longest-word-in-dictionary/solution/
 */
public class LongestWordInDictionary {

    // Trie Node
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        String word;

        public TrieNode() {
            //Char allowed are a-z
            children = new TrieNode[26];
            isWord = false;
        }
    }

    private TrieNode root;

    public LongestWordInDictionary() {
        root = new TrieNode();
    }

    // Time Complexty : O(l * n)
    public void insert(String word) {
        TrieNode current = root;
        for(int i = 0 ; i < word.length(); i++){
            //Doing this to get i = 0, as chat range is a-z;
            int c = word.charAt(i) - 'a';
            if(current.children[c] == null){
                current.children[c] = new TrieNode();
            }
            current = current.children[c];
        }
        current.isWord = true;
        current.word = word;
    }

    // Time Complexity : O(l * n)
    public String findLongestWord() {
        String res = "";
        Stack<TrieNode> stack = new Stack<TrieNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            int size = stack.size();

            //Search each element in stack
            for(int i = 0 ; i < size ; i++){
                //Search each element in children;
                TrieNode current = stack.pop();
                // Since there is more than one possible answer, return the longest word with the smallest lexicographical order
                for(int j = 25 ; j >=0 ; j--){
                    if(current.children[j] != null && current.children[j].isWord){
                        res = current.children[j].word;
                        stack.push(current.children[j]);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestWordInDictionary trie = new LongestWordInDictionary();
        String[] words = {"w","wo","wor","worl", "world"};
        for (String word : words) {
            trie.insert(word);
        }

        System.out.println(trie.findLongestWord());
    }
}
