package Preparation.Specific.T.Programming.Programming.TextJustification_68;

import java.util.ArrayList;
import java.util.List;

public class SampleAns1 {
    public static void main(String[] args) {
        SampleAns1 solution = new SampleAns1();
        String[] words1 = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth1 = 16;
        printLines(solution.fullJustify(words1, maxWidth1));
    }

    private static void printLines(List<String> lines) {
        for (String line : lines) {
            System.out.println("\"" + line + "\"");
        }
    }

    //String [] this is an example of text justification , int len 16
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> rez = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder();
            int count = -1, len = 0, j = i;
            // j is the index after the last word in the line
            // i is the index of the first word

            while (j < words.length && count + words[j].length() + 1 <= maxWidth) {
                count += words[j].length() + 1;
                // len represents the length without space.
                len += words[j].length();
                j++;
            }
            int spaces = 0, dif = 0;
            // if we have n words, there is n - 1 gaps.
            int gaps = j - i - 1;
            // this is for the lst word.
            if (j == words.length || gaps == 0) {
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k != j - 1) sb.append(" ");
                }
                while (sb.length() < maxWidth) sb.append(" ");
            } else {
                //spaces is all the space.
                spaces = (maxWidth - len) / gaps;
                //dif is what leftover
                dif = (maxWidth - len) % gaps;
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k != j - 1) {
                        int spcr = spaces + (dif > 0 ? 1 : 0);
                        while (spcr-- > 0) sb.append(" ");
                        dif--;
                    }
                }
            }
            rez.add(sb.toString());
            i = j - 1;
        }
        return rez;
    }
}

