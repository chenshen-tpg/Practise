package CodingQuestions.Algorithms.Array.ArrayGeneral.MatchingInArray_1408;

import java.util.ArrayList;
import java.util.List;

public class IndexSolution {
    public static void main(String[] args) {
        String[] ss = {"mass", "as", "hero", "superhero"};
        System.out.println(stringMatching(ss));
    }

    public static List<String> stringMatching(String[] words) {
        String str = String.join(" ", words);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (str.indexOf(words[i]) != str.lastIndexOf(words[i])) {
                res.add(words[i]);
            }
        }
        return res;
    }
}
