package CodingQuestions.Array.ArrayGeneral.CountAndSay_38;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
    public String countAndSay(int n) {
        String cur = "1";
        Pattern pattern = Pattern.compile("(.)\\1*");
        for (int i = 1; i < n; ++i) {
            Matcher m = pattern.matcher(cur);
            StringBuilder next = new StringBuilder();
            while (m.find()) next.append(m.group().length() + String.valueOf(m.group().charAt(0)));
            cur = next.toString();
        }
        return cur;
    }
}
