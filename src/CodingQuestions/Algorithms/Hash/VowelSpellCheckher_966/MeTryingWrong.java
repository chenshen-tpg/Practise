package CodingQuestions.Algorithms.Hash.VowelSpellCheckher_966;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MeTryingWrong {
    public static void main(String[] args) {

    }
    public String[] spellchecker(String[] wordlist, String[] queries) {
        HashMap<String, String> hm = new HashMap();
        HashMap<String, String> hmVowel = new HashMap();
        for (String  word : wordlist) {
            StringBuilder matchCharcter = new StringBuilder();
            StringBuilder matchNoVowel = new StringBuilder();
            for (int i = 0; i <  word.length(); i++) {
                char c =  word.charAt(i);
                matchCharcter.append(Character.toLowerCase(c));
                if (!vowelCheck(c)) {
                    matchNoVowel.append(Character.toLowerCase(c));
                }
            }
            hm.put(word, matchCharcter.toString());
            hmVowel.put(word, matchNoVowel.toString());
        }
        List<String> li = new ArrayList();
        for (String query : queries) {
            for (String word : wordlist) {
                if (word.equals(query)) {
                    li.add(word);
                    break;
                }
            }
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < query.length();i++) {
                char c = query.charAt(i);
                if (vowelCheck(c)) {
                    temp.append(c);
                }
            }
            for (String s : hm.keySet()) {
                if (query.equals(hm.get(s))) {
                    li.add(s);
                }
            }
            for (String s : hmVowel.keySet()) {
                if (temp.equals(hmVowel.get(s))) {
                    li.add(s);
                }
            }
        }
        return li.toArray(new String[0]);
    }
    public boolean vowelCheck (char s) {
        if (s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u') {
            return true;
        }
        return false;
    }
}
