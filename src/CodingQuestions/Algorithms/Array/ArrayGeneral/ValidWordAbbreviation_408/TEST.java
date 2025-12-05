package CodingQuestions.Algorithms.Array.ArrayGeneral.ValidWordAbbreviation_408;

public class TEST {
    public static void main(String[] args) {
//        Input: word = "internationalization", abbr = "i12iz4n"
//        Input: word = "apple", abbr = "a2e"
        TEST test = new TEST();
//        System.out.println(test.validWordAbbreviation("internationalization", "i5a11o1")); // true
        System.out.println(test.validWordAbbreviation("abbde", "a1b01e")); // false
//        System.out.println(test.validWordAbbreviation("substitution", "s10n")); // true
//        System.out.println(test.validWordAbbreviation("word", "w1rd")); // false

    }

    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        int len1 = word.length(), len2 = abbr.length();
        while (i < len1 && j < len2) {
            if (Character.isDigit(abbr.charAt(j))) {
                if (abbr.charAt(j) == '0') return false;
                int num = 0;
                while (j < len2 && Character.isDigit(abbr.charAt(j))) {
                    num = num * 10 + Integer.parseInt(abbr.charAt(j) + "");
                    j++;
                }
                i += num;
            } else {
                if (word.charAt(i) != abbr.charAt(j)) {
                    return false;
                }
                i++;
                j++;
            }
        }
        return i == len1 && j == len2;
    }
}
