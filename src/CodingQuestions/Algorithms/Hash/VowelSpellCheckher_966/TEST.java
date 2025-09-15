package CodingQuestions.Algorithms.Hash.VowelSpellCheckher_966;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TEST {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> words = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> caseInsensitive = new HashMap<>();
        Map<String, String> vowelInsensitive = new HashMap<>();
        for (String word : wordlist) {
            String lower = word.toLowerCase();
            caseInsensitive.putIfAbsent(lower, word);
            vowelInsensitive.putIfAbsent(devowel(lower), word);
        }
        String[] res = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            if (words.contains(q)) {
                res[i] = q;
            } else if (caseInsensitive.containsKey(q.toLowerCase())) {
                res[i] = caseInsensitive.get(q.toLowerCase());
            } else if (vowelInsensitive.containsKey(devowel(q.toLowerCase()))) {
                res[i] = vowelInsensitive.get(devowel(q.toLowerCase()));
            } else {
                res[i] = "";
            }
        }
        return res;
    }
    private String devowel(String word) {
        return word.replaceAll("[aeiou]", "#");
    }
    private String devowel1(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) {
                sb.append('#');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
