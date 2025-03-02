package LC_Questions.CollectionAll.Hash.LC75.DetermineIfTwoStringsAreClose_1657;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MeTrying {
    public static void main(String[] args) {
        MeTrying solution = new MeTrying();
        String word1 = "abc";
        String word2 = "bca";
        System.out.println(solution.check(word1,word2));
    }
    public boolean check(String a, String b) {
        if (a.length() != b.length() || a.length() == 0 || b.length() == 0) return false;
        HashMap<Character,Integer> hmA = new HashMap<>();
        HashMap<Character,Integer> hmB = new HashMap<>();
        for (char ac : a.toCharArray()) hmA.put(ac, hmA.getOrDefault(ac, 0) + 1);
        for (char bc : b.toCharArray()) hmB.put(bc, hmB.getOrDefault(bc, 0) + 1);
        if (!hmA.keySet().equals(hmB.keySet())) return false;
        List<Integer> aa = new ArrayList<>(hmA.values());
        List<Integer> bb = new ArrayList<>(hmB.values());
        Collections.sort(aa);
        Collections.sort(bb);
        return aa.equals(bb);
    }
}
