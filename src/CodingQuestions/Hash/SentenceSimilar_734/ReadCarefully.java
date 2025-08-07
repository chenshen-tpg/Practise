package CodingQuestions.Hash.SentenceSimilar_734;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReadCarefully {


    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) return false;
        HashMap<String, Set<String>> hm = new HashMap<>();
        for (List<String> pair : similarPairs) {
            hm.computeIfAbsent(pair.get(0), k -> new HashSet<>()).add(pair.get(1));
            hm.computeIfAbsent(pair.get(1), k -> new HashSet<>()).add(pair.get(0));
        }
        for (int i = 0; i < sentence1.length; i++) {
            String word1 = sentence1[i];
            String word2 = sentence2[i];
            if (word1.equals(word2)) {
                continue;
            }
            if (!hm.getOrDefault(word1, new HashSet<>()).contains(word2) && !hm.getOrDefault(word2, new HashSet<>()).contains(word1)) {
                return false;
            }
        }
        return true;
    }
    public boolean NaviWay(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) return false;
        HashMap<String, Set<String>> hm = new HashMap<>();
        for (List<String> pair : similarPairs) {
            if (!hm.containsKey(pair.get(0))) {
                hm.put(pair.get(0), new HashSet<>());
            }
            hm.get(pair.get(0)).add(pair.get(1));
            if (!hm.containsKey(pair.get(1))) {
                hm.put(pair.get(1), new HashSet<>());
            }
            hm.get(pair.get(1)).add(pair.get(0));
        }
        for (int i = 0; i < sentence1.length; i++) {
            if (sentence1[i].equals(sentence2[i])) {
                continue;
            }
            if (!hm.getOrDefault(sentence1[i], new HashSet<>()).contains(sentence2[i]) && !hm.getOrDefault(sentence1[2], new HashSet<>()).contains(sentence1[i])) {
                return false;
            }
        }
        return true;
    }
}

