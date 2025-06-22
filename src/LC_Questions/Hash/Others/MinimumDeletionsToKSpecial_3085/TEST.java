package LC_Questions.Hash.Others.MinimumDeletionsToKSpecial_3085;

import java.util.HashMap;

public class TEST {
    public static void main(String[] args) {
        minimumDeletions("aaabaaa", 2);
    }
    public static int minimumDeletions(String word, int k) {
        HashMap<Character, Integer> hm = new HashMap();
        for (int i = 0; i < word.length(); i++) {
            hm.put(word.charAt(i),hm.getOrDefault(word.charAt(i), 0) + 1);
        }
        int res = word.length();
        //5321
        for (int i : hm.values()) {
            int temp = 0;
            for (int j : hm.values()) {
                if (i > j) {
                    temp += j;
                } else if (j > i + k) {
                    temp += j - (i + k);
                }
            }
            res = Math.min(res, temp);
        }
        return res;
    }
}
