package Preparation.Specific.Nasdaq.Programming.LeetCodeLike.ReverseWordsInAString_151;

public class TEST {
    public static void main(String[] args) {

    }
    public String reverseWords(String s) {
        s = s.trim();
        String d = s.replaceAll("\\s+", " ");
        String [] c = d.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = c.length - 1; i >= 0; i--) {
            sb.append(c[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
