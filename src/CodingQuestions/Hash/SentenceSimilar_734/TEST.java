package CodingQuestions.Hash.SentenceSimilar_734;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TEST {
    public static void main(String[] args) {
            TEST test = new TEST();

            String[] sentence1 = {"great", "acting", "skills"};
            String[] sentence2 = {"fine", "drama", "talent"};
            List<List<String>> similarPairs = Arrays.asList(
                    Arrays.asList("great", "fine"),
                    Arrays.asList("drama", "acting"),
                    Arrays.asList("skills", "talent")
            );

            boolean result = test.areSentencesSimilar(sentence1, sentence2, similarPairs);
            System.out.println("Are sentences similar? " + result);
    }
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) return false;
        HashMap<String, String> hm = new HashMap();
        for (List<String> similarPair : similarPairs) {
            hm.put(similarPair.get(0), similarPair.get(1));
        }
        for (int i = 0; i < sentence1.length; i++) {
            if (!sentence1[i].equals(sentence2[i]) && !hm.getOrDefault(sentence1[i], "null").equals(sentence2[i])
            && !hm.getOrDefault(sentence2[i], "null").equals(sentence1[i])
            ) return false;
        }
        return true;
    }
}
