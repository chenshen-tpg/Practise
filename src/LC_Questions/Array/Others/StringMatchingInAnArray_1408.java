package LC_Questions.Array.Others;

import java.util.ArrayList;
import java.util.List;

public class StringMatchingInAnArray_1408 {
    public static void main(String[] args) {
        String [] ss = {"mass","as","hero","superhero"};
        System.out.println(stringMatching(ss));
    }
    public static List<String> stringMatching(String[] words) {
        String str = String.join(" ", words);
        List<String> res = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            if(str.indexOf(words[i]) != str.lastIndexOf(words[i])){
                res.add(words[i]);
            }
        }
        return res;
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
