package CodingQuestions.Algorithms.Array.ArrayGeneral.ValidWordAbbreviation_408;


public class SampleAns {
    public static void main(String[] args) {
        SampleAns v = new SampleAns();
        String word4 = "substitution";
        String abbr4 = "sub4u4";
        v.validWordAbbreviation(word4,abbr4);
    }
    public boolean validWordAbbreviation(String word, String abbr) {
        int w = 0, a = 0;
        int al = abbr.length(), wl = word.length();
        int num = 0;
        if (abbr.length() == 0) return true;
        while (w < wl && a < al) {
            if (word.charAt(w) == '0' && word.charAt(a) !='0') return false;
            if (word.charAt(w) == word.charAt(a)){
                w++;
                a++;
            }
            if (Character.isDigit(word.charAt(a))) num  = num * 10 + word.charAt(a) - '0';
        }
        return w == a + num;
    }
}
