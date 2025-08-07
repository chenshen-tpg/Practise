package CodingQuestions.Array.ArrayGeneral.ReverseWordsinaString_151;

public class OnePass {
    public static void main(String[] args) {
        OnePass r = new OnePass();
        String s = "  Bob    Loves  Alice   ";
        System.out.println(r.reverseWords(s));
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
