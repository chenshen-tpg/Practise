package LC_Questions.Hash.LC75.UniqueNumberOfOccurrences_1207;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HM_HS {
    public static void main(String[] args) {

    }
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> hm = new HashMap<>() ;
        for (int a:arr) hm.put(a ,hm.getOrDefault(a,0)+ 1);
        Set<Integer> freqSet = new HashSet<>(hm.values());
        return freqSet.size() == hm.size();
    }
}
