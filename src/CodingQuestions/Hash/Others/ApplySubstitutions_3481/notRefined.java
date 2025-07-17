package CodingQuestions.Hash.Others.ApplySubstitutions_3481;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class notRefined {
    public static void main(String[] args) {

    }

    public String applySubstitutions(List<List<String>> replacements, String text) {
        Map<String, String> hm = new HashMap<>();
        for (List<String> replacement : replacements) {
            hm.put(replacement.get(0), replacement.get(1));
        }
        boolean changed;
        do {
            changed = false;
            for (String key : hm.keySet()) {
                String value = hm.get(key);
                String newValue = value;
                for (String replaceKey : hm.keySet()) {
                    newValue = newValue.replace("%" + replaceKey + "%", hm.get(replaceKey));
                }
                if (!newValue.equals(value)) {
                    hm.put(key, newValue);
                    changed = true;
                }
            }
        } while (changed);
        String result = text;
        for (String key : hm.keySet()) {
            result = result.replace("%" + key + "%", hm.get(key));
        }
        return result;
    }
}
