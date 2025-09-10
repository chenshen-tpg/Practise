package Preparation.Specific.Nasdaq.Programming.LeetCodeLike.GroupAnagrams_49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TEST {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List> hm = new HashMap();
        for (int i = 0; i <strs.length; i++) {
            char [] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String tempString = String.valueOf(temp);
            if (!hm.containsKey(tempString)) {
                hm.put(tempString, new ArrayList());
            }
            hm.get(tempString).add(strs[i]);
        };
        return new ArrayList(hm.values());
    }
}
