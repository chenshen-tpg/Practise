package CodingQuestions.Hash.Others.ConstructKPalindromeStrings_1400;

import java.util.HashMap;

public class ConstructKPalindromeStrings_1400 {
    public static void main(String[] args) {

    }
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) return false;
        if (s.length() == k) return true;
        int count = 0;
        HashMap<Character, Integer> hm = new HashMap();
        for (char c : s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        for (char h:hm.keySet()){
            if (hm.get(h) % 2 == 1) {
                count++;
            }
        }
        return count <= k;
    }

}
