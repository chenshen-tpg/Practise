package CodingQuestions.Array.ArrayGeneral.RemoveKDigits_402;

public class TEST {
    public static void main(String[] args) {
        TEST solution = new TEST();
        solution.removeKDigits("33526221184202197273", 19);
    }

    public String removeKDigits(String num, int k) {
        long minimal = Integer.MAX_VALUE;
        for (int i = 0; i < num.length(); i++) {
            StringBuilder sb = new StringBuilder();
            int count = 0;
            for (int j = i; j < num.length(); j++) {
                if (j + count == num.length()) break;
                if (count++ < k) sb.append(num.charAt(j));
            }
            String tempString = num;
            if (sb.toString().equals(tempString)) return "0";
            long tempVal = Long.valueOf(tempString.replaceFirst(sb.toString(),""));
            minimal = Math.min(minimal, tempVal);
        }
        return String.valueOf(minimal);
    }
}
