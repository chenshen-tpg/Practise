package CodingQuestions.Hash.LC150.GroupAnagrams_49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GroupAnagrams_49 {
    public static void main(String[] args) {
        GroupAnagrams ();
        GroupAnagrams2 ();
    }

    public static void GroupAnagrams (){
        String [] strs = {"eat","tea","tan","ate","nat","bat"};
        HashMap<String, ArrayList> hm = new HashMap<>();
        for (String str : strs) {
            char [] ac = str.toCharArray();
            Arrays.sort(ac);
            String key = new String(ac);
            if (!hm.containsKey(key)) {
                hm.put(key, new ArrayList<>());
            }
            hm.get(key).add(str);
        }
        System.out.println(new ArrayList(hm.values()));
    }

    public static void GroupAnagrams2() {
        String [] strs = {"eat","tea","tan","ate","nat","bat"};
        HashMap<String, ArrayList> hm = new HashMap<>();
        for (String str : strs) {
            int [] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!hm.containsKey(key)) {
                hm.put(key, new ArrayList<>());
            }
            hm.get(key).add(str);
        }
        System.out.println(new ArrayList(hm.values()));
    }
}
