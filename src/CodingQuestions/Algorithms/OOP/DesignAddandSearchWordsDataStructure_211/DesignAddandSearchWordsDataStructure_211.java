package CodingQuestions.Algorithms.OOP.DesignAddandSearchWordsDataStructure_211;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class DesignAddandSearchWordsDataStructure_211 {
    HashMap<Integer, Set<String>> hm;


    public static void main(String[] args) {
        DesignAddandSearchWordsDataStructure_211 w = new DesignAddandSearchWordsDataStructure_211();
        w.WordDictionary();
        w.addWord("bad");
        w.addWord("dad");
        w.addWord("mad");
        System.out.println(w.search("pad"));
        System.out.println(w.search("bad"));
        System.out.println(w.search(".ad"));
        System.out.println(w.search("b.."));
    }
    public void WordDictionary() {
        hm = new HashMap();
    }

    public void addWord(String word) {
        int l = word.length();
        if(!hm.containsKey(l)){
            hm.put(l, new HashSet<>());
        };
        hm.get(l).add(word);
    }

    public boolean search(String word) {
        int m = word.length();
        if (hm.containsKey(m)){
            for (String w : hm.get(m)) {
                int i = 0;
                while ((i < m) && (w.charAt(i) == word.charAt(i) || word.charAt(i) == '.')) {
                    i++;
                }
                if (i == m) {
                    return true;
                }
            }
        }
        return false;
    }
    class WordDictionary {
        private WordDictionary[] children;
        boolean isEndOfWord;
        public WordDictionary() {
            children = new WordDictionary[26];
            isEndOfWord = false;
        }
        public void addWord(String word) {
            WordDictionary curr = this;
            for(char c: word.toCharArray()){
                if(curr.children[c - 'a'] == null)
                    curr.children[c - 'a'] = new WordDictionary();
                curr = curr.children[c - 'a'];
            }
            curr.isEndOfWord = true;
        }
        public boolean search(String word) {
            WordDictionary curr = this;
            for(int i = 0; i < word.length(); ++i){
                char c = word.charAt(i);
                if(c == '.'){
                    for(WordDictionary ch: curr.children)
                        if(ch != null && ch.search(word.substring(i+1))) return true;
                    return false;
                }
                if(curr.children[c - 'a'] == null) return false;
                curr = curr.children[c - 'a'];
            }
            return curr != null && curr.isEndOfWord;
        }
    }
}
