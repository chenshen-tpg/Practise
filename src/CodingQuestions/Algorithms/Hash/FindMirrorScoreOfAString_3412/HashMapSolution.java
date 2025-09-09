package CodingQuestions.Algorithms.Hash.FindMirrorScoreOfAString_3412;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapSolution {

    public static void main(String[] args) {
        System.out.println(hashSolution("aczzx"));
    }

     static long hashSolution(String s) {
        long ans = 0;
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int i = 0; i < s.length(); ++i){
            int cur = s.charAt(i) - 'a';
            int mirror = 25 - cur;
            if (mp.containsKey(mirror) && mp.get(mirror).size() > 0){
                ans += (long)i - (long)mp.get(mirror).get(mp.get(mirror).size() - 1);
                mp.get(mirror).remove(mp.get(mirror).size() - 1);
            } else {
                mp.computeIfAbsent(cur, key -> new ArrayList<>()).add(i);
            }
        }
        return ans;
    }
}
