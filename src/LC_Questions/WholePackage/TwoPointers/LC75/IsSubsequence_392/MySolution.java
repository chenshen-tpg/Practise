package LC_Questions.WholePackage.TwoPointers.LC75.IsSubsequence_392;

public class MySolution {
    public static void main(String[] args) {
        String s = "aaaaaa";
        String t = "bbaaaa";
        System.out.println(helper3(s,t));
    }

    //built-in method
    public static boolean helper (String s, String t) {
        int l = 0, r = s.length();
        while (l < r) {
            if (!t.contains(s.charAt(l)+"")) return false;
            l++;
        }
        return true;
    }

    // have ot have order...
    public static boolean wrong(String s, String t) {
        int mark = 0;
        int [] memo = new int [26];
        for (char ss : s.toCharArray()) {
            memo[ss - 'a']++;
        }
        for (char tt : t.toCharArray()) {
            memo[tt - 'a']++;
        }
        for(int i = 0; i < 26;i++) {
            if (memo[i] == 2) {
                mark++;
            }
        }
        return mark == s.length();
    }

    //j always plus one...
    public static boolean helper3 (String s, String t) {
        int i = 0, j = 0, sLen = s.length(), tLen = t.length();
        while (i < sLen && j < tLen) {
            if (s.charAt(i) == t.charAt(j)) i++;
            j++;
        }
        return i == sLen;
    }
}
