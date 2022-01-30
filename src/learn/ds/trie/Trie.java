package learn.ds.trie;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Insert/delete/search into trie data structure
 *
 * https://www.youtube.com/watch?v=AXjmTQ8LEoI&frags=pl%2Cwn
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/suffixprefix/Trie.java
 *
 */
public class Trie {

    // Basic trie node
    private class TrieNode{
        Map<Character,TrieNode> children;
        boolean endOfWord;

        public TrieNode(){
            children = new HashMap<>();
            endOfWord = false;
        }
    }

    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    /**
     * Time Complexity  : O (l * n) where l is average length of words , n is the number of words
     */
    public void insert(String word){
        TrieNode current = root;
        for(int i =0 ; i < word.length() ; i++){
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null){
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        //mark the current nodes endOfWord as true
        current.endOfWord = true;
    }

    /**
     * Time Complexity  : O(l) where l is the length of word.
     */
    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            //if node does not exist for given char then return false
            if (node == null) {
                return false;
            }
            current = node;
        }
        //return true of current's endOfWord is true else return false.
        return current.endOfWord;
    }

    /**
     * Delete word from trie.
     */
    public void delete(String word) {
        delete(root, word, 0);
    }

    /**
     * Returns true if parent should delete the mapping
     */
    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            //when end of word is reached only delete if currrent.endOfWord is true.
            if (!current.endOfWord) {
                return false;
            }
            current.endOfWord = false;
            //if current has no other mapping then return true
            return current.children.size() == 0;
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

        //if true is returned then delete the mapping of character and trienode reference from map.
        if (shouldDeleteCurrentNode) {
            current.children.remove(ch);
            //return true if no mappings are left in the map.
            return current.children.size() == 0;
        }
        return false;
    }

    public static void main(String[] args) {
        Trie t = new Trie();

        String words[] = {"the", "a", "there", "answer", "any", "by", "bye", "their","apple"};

        for(String word : words){
            t.insert(word);
        }

        System.out.println(t.search("apple"));
    }


}
