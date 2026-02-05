package CodingQuestions.Algorithms.Important.RealQuestions;

import java.util.ArrayList;
import java.util.List;

public class ProcessingString {

    // String without quote and commas
    // single quote, may contains commas or doube quotes,
    // double quote followed by characters may contain commas or single quotes, a last double quote,
    public static void main(String[] args) {

        ProcessingString ps = new ProcessingString();
//        String input1 = "apple,banana,carrot";
//        System.out.println("Input: " + input1);
//        System.out.println("Output: " + ps.processString(input1));

        String input1 = "It's,a,cat";
        System.out.println("Input: " + input1);
        System.out.println("Output: " + ps.processString(input1));

//        String input3 = "\"apple,'banana'\",carrot";
//        System.out.println("Input: " + input3);
//        System.out.println("Output: " + ps.processString(input3));
    }
    public List<String> processString(String input) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < input.length()) {
            char currentChar = input.charAt(i);
            String value;

            if (currentChar == '\'') {
                int nextQuoteIndex = input.indexOf('\'', i + 1);
                value = input.substring(i + 1, nextQuoteIndex);
                i = nextQuoteIndex + 1;
            } else if (currentChar == '"') {
                int nextQuoteIndex = input.indexOf('"', i + 1);
                value = input.substring(i + 1, nextQuoteIndex);
                  i = nextQuoteIndex + 1;
            } else {
                int nextCommaIndex = input.indexOf(',', i);
                if (nextCommaIndex == -1) {
                    value = input.substring(i);
                    i = input.length();
                } else {
                    value = input.substring(i, nextCommaIndex);
                    i = nextCommaIndex;
                }
            }
            result.add(value);
            if (i < input.length() && input.charAt(i) == ',') {
                i++;
            }
        }
        return result;
    }
}
