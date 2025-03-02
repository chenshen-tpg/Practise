package LC_Questions.Array.Others;

public class SubstringMatchingPattern_2407_Q1 {
    public static void main(String[] args) {
        String s = "leetcode", p = "ee*e";

//        System.out.println(hasMatch(s,p));
        System.out.println(s.substring(p.indexOf('*')));
    }
    public static boolean hasMatch(String s, String p) {
        int split = s.indexOf('*');
        int firstPosition = s.indexOf(p.substring(0 , split));
        int secondPosition = s.indexOf(p.substring(split + 1),split + firstPosition);
        return firstPosition != -1 && secondPosition != -1 ? true : false;
    }
    public boolean hasMatchUpVoted(String s, String p) {
        int index = p.indexOf('*');
        int firstpos = s.indexOf(p.substring(0, index));
        int secondpos = s.indexOf(p.substring(index + 1), firstpos + index);
        if (firstpos != -1 && secondpos != -1) {
// comparing if both the firstpos and secondpos are not -1 , if not then it means both patterns are present in the word
            return true;
        }
        return false;
    }

    public boolean hasMatch_Long(String s, String p) {
        int index = -1;
        for(int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '*') {
                index = i;
                break;
            }
        }
        int num1 = fun(s,p.substring(0,index));
        if(num1 == -1) return false;
        int num2 = fun(s.substring(num1), p.substring(index+1));
        return num2 != -1;
    }

    static int fun(String s, String k) {
        int n = s.length();
        int m = k.length();
        int j = 0;
        for(int i = 0; i <= n - m; i++) {
            for(j = 0; j < m; j++) {
                char ch1 = s.charAt(j + i);
                char ch2 = k.charAt(j);
                if(ch1 != ch2) break;
            }
            if (j == m) return i + j;
        }
        return -1;
    }
}
