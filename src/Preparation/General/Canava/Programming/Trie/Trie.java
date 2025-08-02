package Preparation.General.Canava.Programming.Trie;

import java.util.HashMap;
import java.util.Map;



    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;

        public TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }

    public class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode current = root;
            for (char ch : word.toCharArray()) {
                current.children.putIfAbsent(ch, new TrieNode());
                current = current.children.get(ch);
            }
            current.isEndOfWord = true;
        }
        public boolean search(String word) {
            TrieNode current = root;
            for (char ch : word.toCharArray()) {
                if (!current.children.containsKey(ch)) {
                    return false;
                }
                current = current.children.get(ch);
            }
            return current.isEndOfWord;
        }


        public boolean startsWith(String prefix) {
            TrieNode current = root;
            for (char ch : prefix.toCharArray()) {
                if (!current.children.containsKey(ch)) {
                    return false;
                }
                current = current.children.get(ch);
            }
            return true;
        }

        public static void main(String args) {
            Trie trie = new Trie();
            trie.insert("apple");
            System.out.println("Search 'apple': " + trie.search("apple"));   // true
            System.out.println("Search 'app': " + trie.search("app"));     // false (not marked as end of word)
            System.out.println("Starts with 'app': " + trie.startsWith("app")); // true
            trie.insert("app");
            System.out.println("Search 'app' after insert: " + trie.search("app")); // true
            System.out.println("Search 'banana': " + trie.search("banana")); // false
        }
}
