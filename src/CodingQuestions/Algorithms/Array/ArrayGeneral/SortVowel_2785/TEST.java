package CodingQuestions.Algorithms.Array.ArrayGeneral.SortVowel_2785;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//    Given a string s, sort only the vowels (a, e, i, o, u, both uppercase and lowercase) in s in non-decreasing order,
//    while keeping the positions of all other characters unchanged. Return the resulting string.
public class TEST {
    public static void main(String[] args) {
        TEST tester = new TEST();
        // Test 1: Example from problem
        System.out.println(tester.sortVowels("lEetcOde").equals("lEOtcede")); // true
        // Test 2: All vowels
        System.out.println(tester.sortVowels("aeiouAEIOU").equals("AEIOUaeiou")); // true
        // Test 3: No vowels
        System.out.println(tester.sortVowels("bcdfg").equals("bcdfg")); // true
        // Test 4: Empty string
        System.out.println(tester.sortVowels("").equals("")); // true
        // Test 5: Vowels at start and end
        System.out.println(tester.sortVowels("uhelloA").equals("Ahellou")); // true
        // Test 6: Mixed case
        System.out.println(tester.sortVowels("AbEcIdOfU").equals("AbEcIdOfU")); // true
        // Test 7: Single vowel
        System.out.println(tester.sortVowels("a").equals("a")); // true
        // Test 8: Single consonant
        System.out.println(tester.sortVowels("b").equals("b")); // true
        // Test 9: Vowels and consonants alternating
        System.out.println(tester.sortVowels("a1e2i3o4u").equals("a1e2i3o4u")); // true
    }




    public String sortVowels(String s) {
        List<Character> li = new ArrayList();
        StringBuilder left = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if ("aeiou".contains(Character.toLowerCase(cur) +"")){
                left.append('#');
                li.add(cur);
            } else {
                left.append(cur);
            }
        }
        Collections.sort(li);
        String before = left.toString();
        int j = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < before.length(); i++) {
            char cur = before.charAt(i);
            if (cur =='#') {
                res.append(li.get(j++));
            } else {
                res.append(cur);
            }
        }
        return res.toString();
    }
}
