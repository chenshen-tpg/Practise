package LC_Questions.Hash.LC150.RansomNote_383;

import java.util.HashMap;

public class RansomNote_383 {
    public static void main(String[] args) {
        RansomNote_383 rn = new RansomNote_383();
        System.out.println(rn.canConstruct("aa", "aab"));
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        HashMap<Character,Integer> hm = new HashMap();
        for (char m:magazine.toCharArray()) {
            hm.put(m, hm.getOrDefault(m,0) +1);
        }
        for (char r:ransomNote.toCharArray()) {
            if (hm.getOrDefault(r, 0) == 0){
                return false;
            }
            hm.put(r, hm.get(r) - 1);
        }
        return true;
    }
}
