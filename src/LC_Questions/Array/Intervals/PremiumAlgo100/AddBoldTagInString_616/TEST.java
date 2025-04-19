package LC_Questions.Array.Intervals.PremiumAlgo100.AddBoldTagInString_616;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TEST {
    public static void main(String[] args) {
        TEST solution = new TEST();
        solution.addBoldTag("abcxyz123", new String [] {"abc", "123"});
    }
    public String addBoldTag(String s, String[] words) {
        List<String> li = new ArrayList();
        li.addAll(Arrays.asList(words));
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (li.contains(s.substring(i,j))) {
                    s.replace(s.substring(i,j),"<b>" + s.substring(i,j) + "</b>");
                }
            }
        }
        return s;
    }
}
