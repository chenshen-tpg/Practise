package CodingQuestions.OOP.SearchSuggestionsSystem_1268;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SampleAns {
    public static void main(String[] args) {
        String [] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        SampleAns solution = new SampleAns();
        solution.suggestedProducts(products, searchWord);
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
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
