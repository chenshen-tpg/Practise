package LC_Questions.LC_150.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringwithConcatenationofAllWords_30 {
    public static void main(String[] args) {

    }
    public List<Integer> findSubstring(String s, String[] words) {
        List <Integer> ans = new ArrayList<>();
        HashMap<String,Integer> hm = new HashMap<>();
        for (String word:words){
            hm.put(word, hm.getOrDefault(word, 0) + 1);
        }
        int left = 0, right = s.length(), len = words[0].length(), count = words.length;
        while(left < right){
            String sub = s.substring(left, left + len);
            if (hm.containsKey(sub)){
                hm.put(sub, hm.get(sub) - 1);

            }
            left+=len;
        }
        return ans;
    }
}
