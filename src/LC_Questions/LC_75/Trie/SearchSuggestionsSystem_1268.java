package LC_Questions.LC_75.Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class SearchSuggestionsSystem_1268 {

    public static void main(String[] args) {

    }

    public List<List<String>> model_Answer (String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        PriorityQueue<String> heap = new PriorityQueue<>();
        for (int i = 1; i <= searchWord.length(); i++) {
            String t = searchWord.substring(0, i);
            for (String product: products) {
                if (product.startsWith(t)) {
                    heap.offer(product);
                }
                if (heap.size() > 3) heap.poll();
            }
            LinkedList<String> temp = new LinkedList<>();
            while (!heap.isEmpty()) temp.addFirst(heap.poll());
            result.add(temp);
        }
        return result;
    }
    public List<List<String>> suggestedProducts_fromGPT(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        Arrays.sort(products);
        for (int i = 1; i <= searchWord.length(); i++) {
            String prefix = searchWord.substring(0, i);
            List<String> suggestions = new ArrayList<>();
            for (String product : products) {
                if (product.startsWith(prefix)) {
                    suggestions.add(product);
                    if (suggestions.size() == 3) break;
                }
            }
            result.add(suggestions);
        }
        return result;
    }

}
