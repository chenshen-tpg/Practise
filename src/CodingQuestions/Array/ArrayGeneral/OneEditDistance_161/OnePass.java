package CodingQuestions.Array.ArrayGeneral.OneEditDistance_161;

public class OnePass {
    public static void main(String[] args) {

    }
    public boolean isOneEditDistance(String s, String t) {
        int slen = s.length(), tlen = t.length();
        //always iterate the STRING with smaller length
        if (slen > tlen) return isOneEditDistance(t, s);
        if (slen - tlen > 1) return false;
        for (int i = 0; i < slen; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (slen == tlen) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else {
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }
        return (slen + 1 == tlen);
    }
}
