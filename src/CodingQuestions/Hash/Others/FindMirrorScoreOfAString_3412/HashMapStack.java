package CodingQuestions.Hash.Others.FindMirrorScoreOfAString_3412;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class HashMapStack {

    public static void main(String[] args) {
        System.out.println(hashmapStack("aczzx"));
    }

    public static long hashmapStack(String s) {
        int n = s.length();
        long score = 0;

        Map<Integer, Stack<Integer>> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put(i, new Stack<>());
        }

        for (int i = 0; i < n; i++) {
            int chIdx = s.charAt(i) - 'a';
            int mrIdx = 25 - chIdx;

            if (!map.get(mrIdx).isEmpty()) {
                score += i - map.get(mrIdx).pop();
            } else {
                map.get(chIdx).push(i);
            }
        }

        return score;
    }
}
