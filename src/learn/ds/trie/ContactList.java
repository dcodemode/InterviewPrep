package learn.ds.trie;


import java.util.HashMap;
import java.util.Map;

/**
 * @author Varma Penmetsa
 *
 * Create a contact list using tries
 *
 * https://www.youtube.com/watch?v=vlYZb68kAY0&frags=pl%2Cwn
 */
public class ContactList {

    public class TrieNode{
        Map<Character, TrieNode> children;
        int count;

        public TrieNode(){
            children = new HashMap<>();
            count = 1;
        }
    }

    private TrieNode root;

    public ContactList(){
        root = new TrieNode();
    }


    public void addWords(String[] words){
        if(words == null || words.length == 0){
            System.out.println("Nothing to add !!");
            return;
        }
        for(String word : words){
            add(word);
        }
    }

    public void add(String word){
        TrieNode current  = root;
        for(int i=0 ; i < word.length(); i++){
            TrieNode node  = current.children.get(word.charAt(i));
            if(node == null){
                node = new TrieNode();
                current.children.put(word.charAt(i), node);
                current = node;
            }else{
                current = current.children.get(word.charAt(i));
                current.count++;
            }
        }
    }

    public int search(String word){
        TrieNode current = root;
        for(int i =0 ; i < word.length() ; i++){
            TrieNode node = current.children.get(word.charAt(i));
            if(node == null){
                return 0;
            }
            current = node;
        }
        return current.count;
    }

    public static void main(String[] args) {
        String[] words = {"Tom","Tommy","Tom Rider", "Tom Boy", "Jack","Jockey", "Jack Reacher", "Joe", "Adam", "Carla", "Teddy"};

        ContactList c = new ContactList();
        c.addWords(words);
        System.out.println(c.search("C"));

    }
}
