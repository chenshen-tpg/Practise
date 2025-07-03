package LC_Questions.Array.ArrayGeneral.Others.FindKChar_3304;

public class SampleAns {
    public static void main(String[] args) {

    }
    public char kthCharacter(int k) {
        return helper("a", k);
    }
    public char helper (String c, int k) {
        if (c.length() >= k) {
            return c.charAt(k - 1);
        }
        int index = 0;
        StringBuilder sb = new StringBuilder(c);
        while (index < c.length()) {
            sb.append((char) (c.charAt(index++) + 1));
        }
        return helper(sb.toString(), k);
    }
}
