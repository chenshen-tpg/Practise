package LC_Questions.CollectionAll.TwoPointers.Others.ValidWordAbbreviation_408;

public class TwoPointers {
    public static void main(String[] args) {
        String word = "internationalization", abbr = "i12iz4n";
        System.out.println(validAbbr(word, abbr));
    }

    public static boolean validAbbr(String word, String abbr) {
        int i = 0, j = 0, wordLen = word.length(), abbrLen = abbr.length();
        while (j < abbrLen && i < wordLen) {
            if (Character.isLetter(abbr.charAt(j))) {
                if (word.charAt(i) != abbr.charAt(j)) return false;
                i++;
                j++;
            } else if (Character.isDigit(abbr.charAt(j))) {
                if (abbr.charAt(j) == '0') return false;
                int numCount = 0;
                while (j < abbrLen && Character.isDigit(abbr.charAt(j))) {
                    numCount = 10 * numCount + (abbr.charAt(j) - '0');
                    j++;
                }
                if (i + numCount > wordLen) return false;
                i += numCount;
            } else return false;
        }
        return i == wordLen && j == abbrLen;
    }
}