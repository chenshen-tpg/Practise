package LC_Questions.LC_150.GraphBFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class WordLadder_127 {
    public class Pair<K, V> {

        private final K element0;
        private final V element1;

        public <K, V> Pair<K, V> createPair(K element0, V element1) {
            return new Pair<K, V>(element0, element1);
        }

        public Pair(K element0, V element1) {
            this.element0 = element0;
            this.element1 = element1;
        }

        public K getKey() {
            return element0;
        }

        public V getValue() {
            return element1;
        }

    }

    public static void main(String[] args) {

    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int l = beginWord.length();
        Map<String, List<String>> allComb = new HashMap<>();
        wordList.forEach(word -> {
            for (int i = 0; i < l; i++) {
                String newWord = word.substring(0,i) + '*' + word.substring(i+1,l);
                List<String> trans = allComb.getOrDefault(newWord, new ArrayList<>());
                trans.add(word);
                allComb.put(newWord, trans);
            }
        });
        Queue<Pair<String,Integer>> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        while (!q.isEmpty()) {
            Pair<String, Integer> node = q.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < l; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i+1, l);
                for (String adj : allComb.getOrDefault(newWord, new ArrayList<>())) {
                    if (adj.equals(endWord)) {
                        return level + 1;
                    }
                    if (!visited.containsKey(adj)) {
                        visited.put(adj, true);
                        q.add(new Pair(adj, level+1));
                    }
                }
            }
        }
        return 0;
    }
}
