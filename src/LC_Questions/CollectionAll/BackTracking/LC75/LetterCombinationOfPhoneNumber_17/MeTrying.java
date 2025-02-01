package LC_Questions.CollectionAll.BackTracking.LC75.LetterCombinationOfPhoneNumber_17;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MeTrying {
    ArrayList res = new ArrayList();
    static Map<Character, String> letters = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");

    public static void main(String[] args) {
        MeTrying solution = new MeTrying();
        System.out.println(solution.letterCombinations("23"));
    }
    public List<String> letterCombinations(String digits) {
        helper(digits,new StringBuilder(),0);
        return res;
    }

    private void helper(String digits, StringBuilder sb, int start) {
        if (sb.length() ==digits.length()) {
            res.add(sb.toString());
            return;
        }
        String s = letters.get(digits.charAt(start));
        for (char letter : s.toCharArray()) {
            sb.append(letter);
            helper(digits,sb,start+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
