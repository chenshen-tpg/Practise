package Preparation.TipsAndSummary.HashMap;

import java.util.TreeMap;

public class HashMap {
    /***
            TreeMap: Maintains entries in ascending order of keys.
            HashMap: Does not maintain any order of entries.
            LinkedHashMap: Maintains entries in the order they were inserted.
     ***/
    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("test",1);
        map.get(0);
        map.get(map.size() -1);
        map.firstKey();
        map.lastKey();
    }
}
