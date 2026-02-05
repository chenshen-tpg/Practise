package CodingQuestions.Algorithms.Important.RealQuestions.Review;


import java.util.ArrayList;
import java.util.List;

/***
 *Two critical machines in your industry are sending String between each other, you have to split them for further processing
 * The string you get in input defines a sequence of values, separated by commas,
 * One or more characters, with no simple quotes, no double quotes, no commas inside, for example hello
 *  a simple quote, followed by character, you will have to remove the trailing and leading simple quotes
 *  'Hi "to" you' -> Hi "to" you.
 * A double quote, followed by characters which may contain commas or simple quotes, then a last double quote. you will have to remove the trailing and leading double quotes. For example
 * "It's,a,cat" -> It's ,a ,cat.
 * processing of the string
 *
 */
public class VowelFinding {
    public static void main(String[] args) {
        VowelFinding ps = new VowelFinding();
        String input1 = "It's,a,cat";
        System.out.println("Input: " + input1);
        System.out.println("Output: " + ps.processString(input1));

        String input2 = "'Hi \"to\" you'";
        System.out.println("Input: " + input2);
        System.out.println("Output: " + ps.processString(input2));

    }

    public static List<String> processString (String temp) {
        List<String> result = new ArrayList<>();
        int i = 0, n = temp.length();
        while (i < n) {
            if (temp.charAt(i) == '\'') {
                int start = i++;
                while (i < n && temp.charAt(i) != '\'') i++;
                result.add(temp.substring(start, i));
                i++;
                if (i < n && temp.charAt(i) == ',') i++;
            } else if (temp.charAt(i) == '"') {
                int start = i++;
                while (i < n && temp.charAt(i) != '"') i++;
                result.add(temp.substring(start, i));
                i++;
                if (i < n && temp.charAt(i) == ',') i++;
            } else {
                int start = i;
                while (i < n && temp.charAt(i) != ',') i++;
                result.add(temp.substring(start, i));
                if (i < n && temp.charAt(i) == ',') i++;
            }
        }
        return result;
    }
}
