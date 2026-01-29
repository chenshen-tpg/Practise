package CodingQuestions.Algorithms.Array.ArrayGeneral.MatchingInArray_1408;

import java.util.ArrayList;
import java.util.List;

public class Linear {
    public static void main(String[] args) {

    }
    public List<String> stringMatching_BruteForce(String[] words) {
        int n = words.length;
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i != j && words[j].contains(words[i])) {
                    ans.add(words[i]);
                    break;
                }
            }
        }

        return ans;
    }
}
