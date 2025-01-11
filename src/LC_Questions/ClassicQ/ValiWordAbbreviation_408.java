package LC_Questions.ClassicQ;


public class ValiWordAbbreviation_408 {
    public static void main(String[] args) {
        ValiWordAbbreviation_408 v = new ValiWordAbbreviation_408();
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
            char tempw = word.charAt(w);
            char tempa = word.charAt(a);
            if (tempw == '0' && tempa !='0') return false;
            if (word.charAt(w) == word.charAt(a)){
                w++;
                a++;
            }

            if (Character.isDigit(tempa)) {
                num  = num * 10 + tempa - '0';
            }
        }
        return w == a + num;
    }


}
