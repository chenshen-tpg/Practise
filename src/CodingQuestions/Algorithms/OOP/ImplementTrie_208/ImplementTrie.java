package CodingQuestions.Algorithms.OOP.ImplementTrie_208;

import java.util.ArrayList;
import java.util.List;

public class ImplementTrie {
    public static void main(String[] args) {

    }

    class Trie {
        List<String> list;

        public Trie() {
            list = new ArrayList<String>();
        }

        public void insert(String word) {
            list.add(word);
        }

        public boolean search(String word) {
            if (list.contains(word)) return true;
            return false;
        }

        public boolean startsWith(String prefix) {
            for (String s : list) {
                if (s.startsWith(prefix)) return true;
            }
            return false;
        }
    }
}
