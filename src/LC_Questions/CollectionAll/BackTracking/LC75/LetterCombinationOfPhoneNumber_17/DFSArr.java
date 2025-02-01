package LC_Questions.CollectionAll.BackTracking.LC75.LetterCombinationOfPhoneNumber_17;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DFSArr {

    ArrayList res = new ArrayList();
    static Map<Character, String> letters = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");


    public static void main(String[] args) {
        DFSArr l = new DFSArr();
        System.out.println(l.letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return res;
        backtrack(0,new StringBuilder(), digits);
        return res;
    }
    private void backtrack(int index, StringBuilder sb,String digits) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String possibleLetters = letters.get(digits.charAt(index));
        for (char letter: possibleLetters.toCharArray()) {
            sb.append(letter);
            backtrack(index + 1, sb, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
