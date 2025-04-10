package LC_Questions.Array.TwoPointers.LC75.IsSubsequence_392;

public class TwoPointers {
    public static void main(String[] args) {
        TwoPointers is = new TwoPointers();
        System.out.println(is.TwoPointers("abc", "ahbgdc"));
    }


    public boolean TwoPointers(String s, String t) {
        int ss = 0, sn = s.length(), ts = 0,tn = t.length();
        while (ss < sn && ts < tn) {
            if (s.charAt(ss) == t.charAt(ts)) ss++;
            ts++;
        }
        return ss == sn;
    }

}
