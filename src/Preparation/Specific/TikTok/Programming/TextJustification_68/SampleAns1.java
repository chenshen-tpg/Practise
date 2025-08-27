package Preparation.Specific.TikTok.Programming.TextJustification_68;

import java.util.ArrayList;
import java.util.List;

public class SampleAns1 {
    public static void main(String[] args) {
        SampleAns1 solution = new SampleAns1();
        String[] words1 = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth1 = 16;
        System.out.println("Case 1:");
        printLines(solution.fullJustify(words1, maxWidth1));
    }
    private static void printLines(List<String> lines) {
        for (String line : lines) {
            System.out.println("\"" + line + "\"");
        }
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> rez = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder();
            int count = -1, len = 0, j = i;
            while (j < words.length && count + words[j].length() + 1 <= maxWidth) {
                count += words[j].length() + 1;
                len += words[j].length();
                j++;
            }
            int spaces = 0, dif = 0;
            int gaps = j - i - 1;
            if (j == words.length || gaps == 0) {
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k != j - 1) sb.append(" ");
                }
                while (sb.length() < maxWidth) sb.append(" ");
            } else {
                spaces = (maxWidth - len) / gaps;
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

