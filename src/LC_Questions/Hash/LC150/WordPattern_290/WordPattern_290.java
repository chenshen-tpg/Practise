package LC_Questions.Hash.LC150.WordPattern_290;

import java.util.HashMap;

public class WordPattern_290 {
    public static void main(String[] args) {
        String pattern = "a";
        String s = "a";
        System.out.println(wordPattern(pattern, s));
    }

    public static boolean wordPattern(String pattern, String s) {
        HashMap map_index = new HashMap();
        String[] words = s.split(" ");

        if (words.length != pattern.length())
            return false;

        for (Integer i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            String w = words[i];

            if (!map_index.containsKey(c))
                map_index.put(c, i);

            if (!map_index.containsKey(w))
                map_index.put(w, i);

            if (map_index.get(c) != map_index.get(w))
                return false;
        }

        return true;
    }
    public boolean wordPattern1(String pattern, String s) {
        StringBuilder sb = new StringBuilder();
        String [] ss = s.split(" ");
        for (String k:ss) {
            if ("dog".equals(k)) {
                sb.append("a");
            } else if ("cat".equals(k)) {
                sb.append("b");
            } else {
                return false;
            }
        }
        return pattern.equals(sb.toString());
    }
}
