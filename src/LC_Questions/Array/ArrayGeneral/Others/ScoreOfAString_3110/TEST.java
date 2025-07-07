package LC_Questions.Array.ArrayGeneral.Others.ScoreOfAString_3110;

public class TEST {
    public static void main(String[] args) {
        System.out.println(Integer.valueOf('a'));
    }
    public int scoreOfString(String s) {
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            res += Math.abs(Integer.valueOf(s.charAt(i)) - Integer.valueOf(s.charAt(i-1)));
        }
        return res;
    }
}
