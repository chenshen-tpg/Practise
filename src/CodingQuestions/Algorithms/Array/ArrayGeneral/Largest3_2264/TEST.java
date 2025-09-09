package CodingQuestions.Algorithms.Array.ArrayGeneral.Largest3_2264;

public class TEST {
    public static void main(String[] args) {

    }
    public String largestGoodInteger(String num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < num.length() - 1; i++) {
            if (num.charAt(i) == num.charAt(i-1) && num.charAt(i) == num.charAt(i + 1)) {
                sb.append(num.charAt(i));
                if (Integer.valueOf(num.charAt(i)) > Integer.valueOf(sb.toString())){
                    sb = new StringBuilder();
                    sb.append(num.charAt(i));
                }
            }
        }
        return repeat(sb.toString(), 3);
    }
    public static String repeat(String str, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
