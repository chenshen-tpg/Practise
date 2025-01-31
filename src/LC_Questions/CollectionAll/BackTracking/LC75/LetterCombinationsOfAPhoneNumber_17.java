package LC_Questions.CollectionAll.BackTracking.LC75;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber_17 {

    ArrayList combinations = new ArrayList();
    static Map<Character, String> letters = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");


    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber_17 l = new LetterCombinationsOfAPhoneNumber_17();
        System.out.println(l.letterCombinations("23"));
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            return combinations;
        }
        backtrack(0,new StringBuilder(),digits);
        return combinations;
    }
    private void backtrack(int index, StringBuilder path,String digits) {
        if (path.length() == digits.length()) {
            combinations.add(path.toString());
            return;
        }
        String possibleLetters = letters.get(digits.charAt(index));
        for (char letter: possibleLetters.toCharArray()) {
            path.append(letter);
            backtrack(index + 1, path, digits);
            path.deleteCharAt(path.length() - 1);
        }
    }

}
