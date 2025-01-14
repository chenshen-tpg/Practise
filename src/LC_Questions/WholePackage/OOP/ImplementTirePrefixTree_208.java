package LC_Questions.WholePackage.OOP;

import java.util.ArrayList;
import java.util.List;

public class ImplementTirePrefixTree_208 {
    static class Trie1 {

        List<String> list;
        public Trie1() {
            list=new ArrayList<String>();
        }

        public void insert(String word) {
            list.add(word);
        }

        public boolean search(String word) {
            if(list.contains(word)) return true;
            return false;
        }

        public boolean startsWith(String prefix) {
            for(String s:list) {
                if(s.startsWith(prefix)) return true;
            }
            return false;
        }
    }
    static class Trie {
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
        class Node {
            Node[] nodes;
            boolean isEnd;
            Node () {
                nodes = new Node[26];
            }
            private void insert (String word, int idx) {
                if (idx >= word.length()) return;
                int i = word.charAt(idx) - 'a';
                if (nodes [i] == null) {
                    nodes[i] = new Node();
                }
                if (idx == word.length()-1) nodes[i].isEnd = true;
                nodes[i].insert(word, idx+1);
            }
            private boolean search(String word, int idx) {
                if (idx >= word.length()) return false;
                Node node = nodes[word.charAt(idx) - 'a'];
                if (node == null) return false;
                if (idx == word.length() -1 && node.isEnd) return true;
                return node.search(word, idx + 1);
            }
            private boolean startsWith(String prefix, int idx) {
                if (idx >= prefix.length()) return false;
                Node node = nodes[prefix.charAt(idx) - 'a'];
                if (node == null) return false;
                if (idx == prefix.length() - 1) return true;
                return startsWith(prefix, idx + 1);
            }

        }
    }
    public static void main(String[] args) {
        Trie tr = new Trie();
        tr.search("sss");
    }
}
