package CodingQuestions.Algorithms.Array.ArrayGeneral.SortVowel_2785;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TEST {
    public static void main(String[] args) {

    }
    public String sortVowels(String s) {
        List<Character> li = new ArrayList();
        StringBuilder left = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if ("aeiou".contains(Character.toLowerCase(cur) +"")){
                left.append('#');
                li.add(cur);
            } else {
                left.append(cur);
            }
        }
        Collections.sort(li);
        String before = left.toString();
        int j = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < before.length(); i++) {
            char cur = before.charAt(i);
            if (cur =='#') {
                res.append(li.get(j++));
            } else {
                res.append(cur);
            }
        }
        return res.toString();
    }
}
