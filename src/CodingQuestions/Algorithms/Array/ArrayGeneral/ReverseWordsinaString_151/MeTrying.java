package CodingQuestions.Algorithms.Array.ArrayGeneral.ReverseWordsinaString_151;

public class MeTrying {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        String d = s.replaceAll("\\s+", " ");
        String [] temp = d.split(" ");
        for (int i = temp.length - 1; i >= 0; i--) {
            sb.append(temp[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
