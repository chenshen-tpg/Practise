package LC_Questions.OOP.Trie.LC75.SearchSuggestionsSystem_review;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class ListPQ {
    public static void main(String[] args) {
        ListPQ pq = new ListPQ();
        String [] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        pq.ListPQ_Bruteforce(products, searchWord);
    }


    public List<List<String>> ListPQ_Bruteforce (String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        PriorityQueue<String> heap = new PriorityQueue<>();
        for (int i = 1; i <= searchWord.length(); i++) {
            String t = searchWord.substring(0, i);
            for (String product: products) {
                if (product.startsWith(t)) heap.offer(product);
                if (heap.size() > 3) heap.poll();
            }
            LinkedList<String> temp = new LinkedList<>();
            while (!heap.isEmpty()) temp.addFirst(heap.poll());
            result.add(temp);
        }
        return result;
    }

}
