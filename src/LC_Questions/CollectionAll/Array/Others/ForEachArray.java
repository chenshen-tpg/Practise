package LC_Questions.CollectionAll.Array.Others;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEachArray {

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        String beginWord = "hit";
        int l = beginWord.length();
        Map<String, List<String>> allComb = new HashMap<>();
        wordList.forEach(word -> {
            for (int i = 0; i < l; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i+1, l);
                List<String> trans = allComb.getOrDefault(newWord, new ArrayList<>());
                trans.add(word);
                allComb.put(newWord, trans);
            }
        });
        System.out.println("end");
    }

}
