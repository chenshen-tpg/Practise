package CodingQuestions.Algorithms.Array.ArrayGeneral.CountAndSay_38;

public class Wrong {
    public static void main(String[] args) {
        Wrong solution = new Wrong();
        solution.countAndSay(1211);
    }

    public String countAndSay(int n) {
        String temp = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < temp.length() - 1; i++) {
            int counter = 0;
            while (i < temp.length() - 1 && temp.charAt(i) == temp.charAt(i + 1)) {
                counter++;
                i++;
            }
            if (counter != 0) sb.append(temp.charAt(i)+ "" + counter +"" );
            if (temp.charAt(i) != temp.charAt(i + 1)) {
                sb.append(temp.charAt(i) +""+ 1 + "");
            }
        }
        return sb.toString();
    }
}
