package LC_Questions.CollectionAll.BackTracking.LC75.LetterCombinationOfPhoneNumber_17;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MeTrying {
    ArrayList res = new ArrayList();
    static Map<Character, String> letters;
    static {
        letters.put('2', "abc");
        letters.put('3', "def");
        letters.put('4', "ghi");
        letters.put('5', "jkl");
        letters.put('6', "mno");
        letters.put('7', "pqrs");
        letters.put('8', "tuv");
        letters.put('9', "wxyz");
    }
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
