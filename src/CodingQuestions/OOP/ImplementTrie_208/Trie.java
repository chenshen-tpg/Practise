package CodingQuestions.OOP.ImplementTrie_208;

import java.util.Arrays;

public class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        root.insert(word, 0);
    }

    public boolean search(String word) {
        return root.search(word, 0);
    }

    public boolean startsWith(String prefix) {
        return root.startsWith(prefix, 0);
    }

    public static void main(String[] args) {
        String[] operations = {"Trie", "insert", "search", "search", "startsWith", "insert", "search"};
        String[][] inputs = {{}, {"apple"}, {"apple"}, {"app"}, {"app"}, {"app"}, {"app"}};
        System.out.println(Arrays.toString(execute(operations, inputs)));
    }
    public static Object[] execute(String[] operations, String[][] inputs) {
        Object[] results = new Object[operations.length];
        Trie trie = null;
        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "Trie":
                    trie = new Trie();
                    results[i] = null;
                    break;
                case "insert":
                    trie.insert(inputs[i][0]);
                    results[i] = null;
                    break;
                case "search":
                    results[i] = trie.search(inputs[i][0]);
                    break;
                case "startsWith":
                    results[i] = trie.startsWith(inputs[i][0]);
                    break;
            }
        }
        return results;
    }
    class Node {
        Node[] nodes;
        boolean isEnd;

        Node() {
            nodes = new Node[26];
        }

        private void insert(String word, int idx) {
            if (idx >= word.length()) return;
            int i = word.charAt(idx) - 'a';
            if (nodes[i] == null) {
                nodes[i] = new Node();
            }
            if (idx == word.length()-1) nodes[i].isEnd = true;
            nodes[i].insert(word, idx+1);
        }

        private boolean search(String word, int idx) {
            if (idx >= word.length()) return false;
            Node node = nodes[word.charAt(idx) - 'a'];
            if (node == null) return false;
            if (idx == word.length() - 1 && node.isEnd) return true;
            return node.search(word, idx+1);

        }

        private boolean startsWith(String prefix, int idx) {
            if (idx >= prefix.length()) return false;
            Node node = nodes[prefix.charAt(idx) - 'a'];
            if (node == null) return false;
            if (idx == prefix.length() - 1) return true;
            return node.startsWith(prefix, idx+1);
        }
    }
}
