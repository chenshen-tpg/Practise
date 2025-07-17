package CodingQuestions.Array.ArrayGeneral.Others.RemoveKDigits_402;

public class GPTVersion {
    public static void main(String[] args) {
        TEST solution = new TEST();
        solution.removeKDigits("33526221184202197273", 19);
    }

    public String removeKDigits(String num, int k) {
        if (k == num.length()) return "0";
        StringBuilder sb = new StringBuilder();
        for (char digit : num.toCharArray()) {
            while (k > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) > digit) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            sb.append(digit);
        }
        while (k > 0) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }
        int i = 0;
        while (i < sb.length() - 1 && sb.charAt(i) == '0') sb.deleteCharAt(i);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
