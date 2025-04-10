package LC_Questions.Array.Hash.Others.ApplySubstitutions_3481;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TEST {
    public static void main(String[] args) {
        TEST solution = new TEST();
        List<List<String>> replacements = Arrays.asList(
                Arrays.asList("A", "bce"),
                Arrays.asList("B", "ace"),
                Arrays.asList("C", "abc%B%")
        );
        String text = "%A%_%B%_%C%";
        solution.applySubstitutions(replacements, text);
    }

    public String applySubstitutions(List<List<String>> replacements, String text) {
        Map<String, String> hm = new HashMap();
        for (List<String> replacement : replacements) {
            hm.put(replacement.get(0), replacement.get(1));
        }
        for (String str : hm.keySet()) {
            String temp = hm.get(str);
            while (temp.contains("%")) {
                int cord = temp.indexOf("%") + 1;
                temp = temp.replace("%"+ temp.charAt(cord) +"%",   hm.get(temp.charAt(cord) + ""));
                hm.put(str, temp);
            }
        }
        while (text.contains("%")) {
            int cord = text.indexOf("%") + 1;
            text = text.replace("%"+ text.charAt(cord) +"%",   hm.get(text.charAt(cord) + ""));
        }
        return text;
    }
}
