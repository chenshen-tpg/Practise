package CodingQuestions.Hash.Others.CountVowelSubStringOfAString_2062;

import java.util.HashSet;
import java.util.Set;

public class HashSetSolution {
    public int countVowelSubstrings(String word) {
        int res = 0;
        for (int i = 0; i < word.length(); i++) {
            Set<Character> set = new HashSet<Character>() {
            };
            for (int j = i; j < word.length(); j++) {
                if (word.charAt(j) == 'a' || word.charAt(j) == 'e' || word.charAt(j) == 'i' || word.charAt(j) == 'o' || word.charAt(j) == 'u') {
                    set.add(word.charAt(j));
                    if (set.size() > 4) res++;
                } else break;
            }
        }
        return res;
    }
}
