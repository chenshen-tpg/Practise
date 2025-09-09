package CodingQuestions.Algorithms.Array.ArrayGeneral.Largest3_2264;

public class SampleAns1 {
    public String largestGoodInteger(String num) {
        char maxDigit = ' ';
        boolean foundGoodInteger = false;
        for (int i = 0; i <= num.length() - 3; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i + 1) == num.charAt(i + 2)) {
                foundGoodInteger = true;
                if (maxDigit == ' ' || num.charAt(i) > maxDigit) {
                    maxDigit = num.charAt(i);
                }
            }
        }
        if (!foundGoodInteger) {
            return "";
        }
        return String.valueOf(maxDigit);
    }
}
