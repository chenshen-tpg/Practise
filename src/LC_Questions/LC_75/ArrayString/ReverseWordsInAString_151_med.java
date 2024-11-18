package LC_Questions.LC_75.ArrayString;

public class ReverseWordsInAString_151_med {
    public static void main(String[] args) {
        ReverseWordsInAString_151_med rw = new ReverseWordsInAString_151_med();
        System.out.println(rw.reverseWords("  hello world  "));
    }
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        String[] arrOfStr = s.split("\\s+");

        for (int i = arrOfStr.length - 1; i >= 0; i--) {
            sb.append(arrOfStr[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
