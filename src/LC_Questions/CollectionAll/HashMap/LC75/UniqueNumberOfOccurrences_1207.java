package LC_Questions.CollectionAll.HashMap.LC75;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences_1207 {
    public static void main(String[] args) {

    }
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> hs = new HashMap<>() ;
        for(int a:arr){
            // freq.put(num, freq.getOrDefault(num, 0) + 1);
            if(!hs.containsKey(a)) {
                hs.put(a,1);
            }else{
                hs.put(a,hs.get(a) + 1);
            }
        }
        Set<Integer> freqSet = new HashSet<>(hs.values());

        return freqSet.size() == hs.size();
    }
}
